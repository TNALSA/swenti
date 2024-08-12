# 📰 SWENTI
SWENTI는 Naver, Daum 웹사이트의 IT 관련 뉴스를 크롤링하여 제공합니다.

## 💻 프로젝트 소개
###### Crawling을 통해 IT 뉴스 데이터를 수집하고 이를 한눈에 보기 쉽게 제공하는 웹사이트 입니다.

## ⏰ 개발 기간
2024.06 ~ 2024.08

## 🧑‍🤝‍🧑 개발 인원
개인 프로젝트 - 1명

## 🌳 프로젝트 환경
- _Language:_ <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=Java&logoColor=white"/> <img src="https://img.shields.io/badge/Python-3776AB?style=flat&logo=Python&logoColor=yellow"> <br/>
- _Framwork:_ <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat&logo=Spring&logoColor=white"> <br/>
- _Database:_ <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"> <br/>
- _Frontend:_ <img src="https://img.shields.io/badge/Vuejs-4FC08D?style=flat&logo=Vuedotjs&logoColor=white"> <br/>
- _Crawling:_ <img src="https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=Selenium&logoColor=white"> <br/>
- _Server:_ <img src="https://img.shields.io/badge/Docker-2496ED?style=flat&logo=Docker&logoColor=white"> <br/>
- _IDE:_ <img src="https://img.shields.io/badge/intellijidea-7D00FF?style=flat&logo=intellijidea&logoColor=white"> <br/>

## 📂 프로젝트 구성
### _시스템 아키텍처_
<img src="https://github.com/user-attachments/assets/2c9e88ff-e26c-4088-b86c-d89520efbd19"/><br/>

* `BeatifulSoup`과 `Selenium` Library를 이용하여 Naver와 Daum Website에서 IT 뉴스 데이터를 수집하고 `Linux`의 Crontab 스케줄러를 이용하여 1시간 마다 주기적으로 크롤링하도록 하였습니다.
* 또한, 이 Crawling한 데이터는 Database에 자동으로 적재될 수 있도록 구성하였습니다.
* 웹사이트 접속 시 Backend 부로 뉴스 데이터 요청을 전송하게 되며, DB에서 해당 데이터를 불러와 사용자 요청에 대한 적절한 결과 값을 반환합니다.
* 서버는 `Docker` 위에 Container 단위로 구성하였습니다.
* 각각의 Container는 Swenti-NET이라는 `Docker` 네트워크를 공유하여 컨테이너 간 접속을 원활하게 할 수 있도록 하였습니다.

### _ERD_
<img src="https://github.com/user-attachments/assets/d3b00691-f445-4726-a31c-9db2998ddef5"/>


### _기능_
#### 로그인
  사용자는 아이디와 비밀번호를 입력하여 로그인 할 수 있습니다. <br/>
  정확한 정보를 입력해야지만 로그인이 가능합니다. <br/>
  
#### 내 정보
- **내정보 조회** <br/>
  로그인에 성공한 사용자는 내 정보를 확인할 수 있습니다. <br/>

- **내 정보 수정** <br/>
  로그인의 성공한 사용자는 내 정보를 수정할 수 있습니다. <br/>
  이름과 생년월일을 제외한 항목들은 수정이 가능합니다. <br/>
    
#### 뉴스 기사 조회 
  - **뉴스 기사 전체 조회** <br/>
    사용자는 웹사이트 접속 시 금일 날짜의 IT 관련 뉴스를 확인할 수 있습니다. <br/>
    뉴스 기사는 기사 작성일의 내림차 순으로 정렬되어 보여집니다. <br/>
    
  - **뉴스 기사 사이트 별(Daum, Naver) 조회** <br/>
    사용자는 원하는 사이트 별로 뉴스 기사를 확인할 수 있습니다. <br/>
    
  - **뉴스 기사 상세 내용 조회** <br/>
    사용자는 뉴스 기사 리스트 중 특정 기사를 선택하여 해당 기사에 대한 내용을 상세하게 볼 수 있습니다. <br/>
    상세 내용에는 기사 제목, 작성자, 언론사, 작성 일자, 기사 내용, 댓글 등이 포함되어 있습니다. <br/>
    뉴스 기사에 대한 상세 내용은 로그인을 하지 않아도 조회가 가능합니다. <br/>
    
#### 댓글
  - **댓글 작성** <br/>
    사용자는 특정 뉴스 기사에 대해 댓글 작성이 가능합니다. <br/>
    해당 기능은 로그인을 성공한 사용자만 이용 가능하며, `<뉴스 기사 상세내용>`에서 댓글 작성이 가능합니다. <br/>
  
  - **댓글 삭제** <br/>
    사용자는 자신이 직접 작성한 댓글을 삭제할 수 있습니다. <br/>
    해당 가능은 로그인을 성공한 사용자만 가능합니다. <br/>
    
#### 북마크 
- **북마크** <br/>
  사용자는 특정 기사에 대해 북마크를 설정할 수 있습니다. <br/>
  해당 기능은 로그인을 성공한 사용자만 이용 가능하며, `<뉴스 기사 상세보기>`에서 북마크 표시를 선택하면 북마크가 설정됩니다. <br/>
  
- **북마크 한 기사 조회** <br/>
  사용자는 자신이 북마크한 기사들을 확인할 수 있습니다. <br/>
  `<내 정보>`에서 북마크한 기사들의 목록들을 확인할 수 있습니다. <br/>

## 👣 프로젝트 구현
### _뉴스 기사 전체 조회_
<img src="https://github.com/user-attachments/assets/41846ac7-0003-440f-95b1-55792b41dd9e"  width="600" height="400"/> <br/>
* `네이버`, `다음` 버튼을 통하여 사이트 별 기사를 조회할 수 있습니다.
-----

### _뉴스 기사 상세내용_
<img src="https://github.com/user-attachments/assets/88e3d9a8-5e29-43c8-be9e-b1e153d814a8"  width="500" height="400" /> <br/>

-----

### _댓글_
<img src="https://github.com/user-attachments/assets/32f2b780-91fd-4574-862f-e54d4ac6dff0" width="500" height="600"/> <br/> 

* 로그인 한 사용자만 댓글 작성이 가능합니다.
* `<기사 상세내용>` 하단부에서 여러 사용자들이 작성한 댓글들을 확인할 수 있습니다.
* 또한, 자신이 작성한 댓글만 삭제가 가능합니다.
-----

### _북마크_
<img src="https://github.com/user-attachments/assets/470fa403-1bc8-406c-804a-713119e8fb5e" width="700" height="150"/> <br/> 
* 로그인 한 사용자만 북마크 기능을 이용할 수 있습니다.
* 사용자는 기사 제목 옆 북마크 아이콘을 통해 북마크를 지정할 수 있습니다.
* 북마크로 지정한 기사들은 `<내 정보>`에서 확인이 가능합니다.
-----

### _북마크 조회_
<img src="https://github.com/user-attachments/assets/7e0e2ff2-d83e-49d5-8750-21586cbf8aa9" width="700" /> <br/>
* 로그인 한 사용자는 자신이 북마크 설정한 기사들을 확인할 수 있습니다.
* 해당 기사 선택 시 `<기사 상세내용>`으로 이어집니다.


  
