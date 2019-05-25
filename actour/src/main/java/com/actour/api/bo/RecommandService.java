package com.actour.api.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actour.api.dao.ProductModelForRecommand;
import com.actour.api.dao.UserForRecommand;
import com.actour.api.mapper.UserMapper;
import com.mysql.cj.Query;

@Service
public class RecommandService {
	@Autowired
	UserMapper userMapper;

	public List<ProductModelForRecommand> getRecommandByContentBase(int systemId) {

		ArrayList<ProductModelForRecommand> RecommendListResult = new ArrayList<>();
		UserForRecommand userforRecommand = userMapper.getUserForRecommand(systemId);
		double[] points = new double[5];
		points[0] = userforRecommand.getAdventure();
		points[1] = userforRecommand.getEater();
		points[2] = userforRecommand.getPhoto();
		points[3] = userforRecommand.getActor();
		points[4] = userforRecommand.getHealing();

		String[] variousNames = { "adventure", "eater", "photo", "actor", "healing" };
		int firstIdx = 0;
		double max = 0;

		for (int j = 0; j < 5; j++) {
			if (points[j] > max) {
				max = points[j];
				firstIdx = j;
			}
		}

		// 1차 필터링 DB를 통해 max-0.5~max+1
		List<ProductModelForRecommand> PRMlist = userMapper.getProductList(variousNames[firstIdx], max - 0.5, max + 1);
		System.out.println(PRMlist.size());
		double[] diffPoints = new double[PRMlist.size()];
		for (int i = 0; i < PRMlist.size(); i++) {
			ProductModelForRecommand productModel = PRMlist.get(i);
			double[] pointsofList = new double[5];
			pointsofList[0] = productModel.getAdventure();
			pointsofList[1] = productModel.getEater();
			pointsofList[2] = productModel.getPhoto();
			pointsofList[3] = productModel.getActor();
			pointsofList[4] = productModel.getHealing();

			for (int j = 0; j < 5; j++) {
				diffPoints[i] += Math.pow(points[j] - pointsofList[j], 2);
			}
		}
		int idx = 0;
		int[] idxOfRecommand = new int[3];
		double[] recommandTop3Diff = new double[3];
		for (int i = 0; i < 3; i++) {
			double minOfDiff = Double.MAX_VALUE;
			for (int j = 0; j < PRMlist.size(); j++) {
				if (minOfDiff > diffPoints[j]) {
					minOfDiff = diffPoints[j];
					idx = j;
				}
			}
			idxOfRecommand[i] = idx;
			recommandTop3Diff[i] = diffPoints[idx];
			diffPoints[idx] = Double.MAX_VALUE;
			RecommendListResult.add(PRMlist.get(idx));
			System.out.println("recommendation List is = " + idx + "'s : " + recommandTop3Diff[i] + "product ID : "
					+ PRMlist.get(idx).getId());
		}
		return RecommendListResult;

	}

}
