//package com.koreaIT.webProjectMuk.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.gax.core.FixedCredentialsProvider;
//import com.google.api.gax.rpc.ApiException;
//import com.google.photos.library.v1.PhotosLibraryClient;
//import com.google.photos.library.v1.PhotosLibrarySettings;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//public class UsrApiController {
//
//	@Value("${OAuth2.0.google.authUrl}")
//	private String googleAuthUrl;
//
//	@Value("${OAuth2.0.google.loginUrl}")
//	private String googleLoginUrl;
//
//	@Value("${OAuth2.0.google.redirectUrl}")
//	private String googleRedirectUrl;
//
//	@Value("${OAuth2.0.google.clientId}")
//	private String googleClientId;
//
//	@Value("${OAuth2.0.google.clientSecret}")
//	private String googleClientSecret;
//
//	@Value("${OAuth2.0.google.scope}")
//	private String googleScope;
//
//	/*
//	 * // 구글 로그인창 호출 // http://localhost:8081/login/getGoogleAuthUrl
//	 * 
//	 * @GetMapping(value = "/login/getGoogleAuthUrl") public ResponseEntity<?>
//	 * getGoogleAuthUrl(HttpServletRequest request) throws Exception {
//	 * 
//	 * String reqUrl = "https://accounts.google.com/o/oauth2/v2/auth?client_id=" +
//	 * googleClientId + "&redirect_uri=" + googleRedirectUrl + "&scope=" +
//	 * googleScope + "&response_type=code&access_type=offline";
//	 * 
//	 * log.info("myLog-LoginUrl : {}", googleLoginUrl);
//	 * log.info("myLog-ClientId : {}", googleClientId);
//	 * log.info("myLog-RedirectUrl : {}", googleRedirectUrl);
//	 * 
//	 * HttpHeaders headers = new HttpHeaders();
//	 * headers.setLocation(URI.create(reqUrl));
//	 * 
//	 * // 1.reqUrl 구글로그인 창을 띄우고, 로그인 후 /login/oauth_google_check 으로 리다이렉션하게 한다.
//	 * return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY); }
//	 * 
//	 * // 구글에서 리다이렉션
//	 * 
//	 * @GetMapping(value = "/login/oauth_google_check") public AccessToken
//	 * oauth_google_check(HttpServletRequest request, @RequestParam(value = "code")
//	 * String authCode, HttpServletResponse response) throws IOException {
//	 * 
//	 * // 2.구글에 등록된 레드망고 설정정보를 보내어 약속된 토큰을 받기 위한 객체 생성 GoogleOAuthRequest
//	 * googleOAuthRequest = GoogleOAuthRequest.builder().clientId(googleClientId)
//	 * .clientSecret(googleClientSecret).code(authCode).redirectUri(
//	 * googleRedirectUrl) .grantType("authorization_code").build();
//	 * 
//	 * RestTemplate restTemplate = new RestTemplate();
//	 * 
//	 * // 3.토큰요청을 한다. ResponseEntity<GoogleLoginResponse> apiResponse =
//	 * restTemplate.postForEntity(googleAuthUrl + "/token", googleOAuthRequest,
//	 * GoogleLoginResponse.class);
//	 * 
//	 * // 4.받은 토큰을 토큰객체에 저장 GoogleLoginResponse googleLoginResponse =
//	 * apiResponse.getBody(); // Sample JSON response from token endpoint
//	 * 
//	 * String accessTokenValue = googleLoginResponse.getAccess_token(); long
//	 * expiresIn = Long.parseLong(googleLoginResponse.getExpires_in());
//	 * 
//	 * // Create AccessToken object with the received token and expiration
//	 * AccessToken accessToken = new AccessToken(accessTokenValue, new
//	 * Date(expiresIn));
//	 * 
//	 * GoogleCredentials credentials = GoogleCredentials.create(accessToken);
//	 * 
//	 * PhotosLibrarySettings settings = PhotosLibrarySettings.newBuilder()
//	 * .setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build()
//	 * ;
//	 * 
//	 * try (PhotosLibraryClient photosLibraryClient =
//	 * PhotosLibraryClient.initialize(settings)) {
//	 * 
//	 * ListAlbumsPagedResponse response2 = photosLibraryClient.listAlbums();
//	 * 
//	 * for (Album album : response2.iterateAll()) { // Get some properties of an
//	 * album String id = album.getId(); String title = album.getTitle(); String
//	 * productUrl = album.getProductUrl(); String coverPhotoBaseUrl =
//	 * album.getCoverPhotoBaseUrl(); // The cover photo media item id field may be
//	 * empty String coverPhotoMediaItemId = album.getCoverPhotoMediaItemId();
//	 * boolean isWritable = album.getIsWriteable(); long mediaItemsCount =
//	 * album.getMediaItemsCount(); }
//	 * 
//	 * } catch (ApiException e) { // Error during album creation
//	 * e.printStackTrace(); }
//	 * 
//	 * return accessToken; }
//	 */
//
//}