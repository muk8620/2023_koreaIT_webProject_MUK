package com.koreaIT.webProjectMuk.controller;


import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.photos.library.v1.PhotosLibraryClient;
import com.google.photos.library.v1.PhotosLibrarySettings;
import com.google.photos.types.proto.Album;
import com.koreaIT.webProjectMuk.util.Util;


@Controller
public class UsrApiController {
	
	@RequestMapping("/usr/api/APITest2")
	public String APITest() throws IOException {
		
		GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\wnrto\\Desktop\\coding(dlatl)\\client_secret_1085307948053-eomnkhsbc8091e1e2jql8hfkj3bo4sfl.apps.googleusercontent.com.json"));
		credentials.refreshIfExpired();
		AccessToken token = credentials.getAccessToken();
		// Set up the Photos Library Client that interacts with the API
		PhotosLibrarySettings settings =
		     PhotosLibrarySettings.newBuilder()
		    .setCredentialsProvider(
		        FixedCredentialsProvider.create(credentials)) 
		    .build();

		try (PhotosLibraryClient photosLibraryClient =
		    PhotosLibraryClient.initialize(settings)) {

		    // Create a new Album  with at title
		    Album createdAlbum = photosLibraryClient.createAlbum("My Album");

		    // Get some properties from the album, such as its ID and product URL
//		    String id = album.getId();
//		    String url = album.getProductUrl();

		} catch (ApiException e) {
		    // Error during album creation
			Util.jsHistoryBack("에러 발생");
		}
		return "usr/api/APITest2";
	}
	
}