# NaverCloudDevOps_season3
네이버 클라우드 데브옵스 3기 과정


#git이 처음일 경우#
이메일과 유저명 확인
git config --global user.name "[사용자명]"
git config --global user.email "[사용자이메일]"


git bash

1. git init -> git과 연동할 폴더 초기화
2. git remote add origin https://github.com/jaeyoung99-lee/NaverCloudDevOps_season3.git        //git remote add origin 원격저장소, git 원격저장소에 새로 연결 
   오류가 나서 새로운 깃 저장소랑 연결이 안될 경우 : git remote set-url origin 원격저장소
3. git branch -> branch 조회
4. git add . 또는 git add 파일명 -> 해당 파일들을 로컬 저장소에 추가
5. git commit -m "메시지" -> 해당 메시지와 함께 위의 파일들을 로컬저장소에 커밋
6. git push origin master(main) -> 원격저장소의 master(main) 브랜치에 소스 보내기
