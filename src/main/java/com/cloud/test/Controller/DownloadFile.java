package com.cloud.test.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.test.utils.CreateHttpConnection;

/**
 * <h2>DownloadFile</h2> downlaod a file from Box( cloud content management and
 * file sharing service)
 * 
 * 
 * @author SAKSHI
 *
 */
@RestController
public class DownloadFile {

	/**
	 * @param name
	 * @param targetPath
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/vermsa7/downloadFile")
	public String apiGetFileByPath(@RequestParam(name = "fileName") String name,
			@RequestParam(name = "path") String targetPath) throws IOException {

		String url = "https://staging.cloud-elements.com/elements/api-v2/files?path=" + "%2Fdoc%2F" + name;

		JSONObject responseJson = new JSONObject();

		CreateHttpConnection httpConnect = new CreateHttpConnection();

		StringBuilder content = httpConnect.responseContent(url);

		Path path = Paths.get("D:\\" + targetPath);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
		File targetFile = new File(path.toString(), "targetFile.txt");
		if (!targetFile.exists()) {
			targetFile.createNewFile();
		}

		Writer targetFileWriter = new FileWriter(targetFile);
		targetFileWriter.write(content.toString());
		targetFileWriter.close();

		responseJson.put("message", "File Downloaded Successfully");
		responseJson.put("statusCode", "200");
		responseJson.put("filePath", path.toString());

		return responseJson.toString();

	}
}
