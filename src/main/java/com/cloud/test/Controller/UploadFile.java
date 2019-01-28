package com.cloud.test.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.test.utils.MultipartUtility;

/**
 * @author SAKSHI
 *
 */
@RestController
public class UploadFile {

	/**
	 * @param name
	 * @param pathToUpload
	 */
	@RequestMapping("vermsa7/uploadFile")
	public void uploadFile(@RequestParam(name = "imageName") String name,
			@RequestParam(name = "pathToUplaod") String pathToUpload) {
		String charset = "UTF-8";
		File uploadFile1 = new File(pathToUpload + name);// testing purpose

		String requestURL = "https://staging.cloud-elements.com/elements/api-v2/files?path=" + pathToUpload + name;

		try {
			MultipartUtility multipart = new MultipartUtility(requestURL, charset);

			multipart.addFilePart("fileUpload", uploadFile1);

			ArrayList<String> response = (ArrayList<String>) multipart.finish();

			System.out.println("SERVER REPLIED:");

			for (String line : response) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}

	}

}
