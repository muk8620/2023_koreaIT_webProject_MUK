yml파일에 올리지 않은 정보 목록(코드 테스트 하려면 yml파일에 따로 추가해야함)
google:
  auth:
    url: https://oauth2.googleapis.com
  login:
    url: https://accounts.google.com
  redirect:
    url: http://localhost:8080/login/oauth_google_check
  client:
    id: <google client ID> 
  secret: <google client secret>