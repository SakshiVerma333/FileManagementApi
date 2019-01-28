package com.cloud.test.Controller;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.test.utils.CreateHttpConnection;

/**
 * <h2>ListFileByFolder</h2> Use API to get list of files from a folder in Box(
 * cloud content management and file sharing service)
 * 
 * @author SAKSHI
 *
 */
@RestController
public class ListFileByFolder {

	/**
	 * @param folderId
	 * @return
	 * @throws ProtocolException
	 * @throws IOException
	 */
	@RequestMapping("/vermsa7/getFileByFolderId")
	public String listFile(@RequestParam(name = "folderId") String folderId) throws ProtocolException, IOException {

		String url = "https://staging.cloud-elements.com/elements/api-v2/folders/" + folderId + "/contents";

		CreateHttpConnection httpConnect = new CreateHttpConnection();
		StringBuilder content = httpConnect.responseContent(url);
		
		JSONObject contentDetailObj = null;
		ArrayList<String> arrayList = new ArrayList<>();
		JSONArray fileDetails = new JSONArray(content.toString());
		for (int i = 0; i < fileDetails.length(); i++) {
			contentDetailObj = fileDetails.getJSONObject(i);
			arrayList.add(contentDetailObj.get("name").toString());
		}

		return arrayList.toString();
	}
}
