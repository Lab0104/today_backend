# today-backend
- (1) Git Flow
  - master : 최종 배포되는 브랜치   
  - develop : 개발을 위한 브랜치   
  - release : 배포 전 품질검사를 진행하는 브랜치  
  - feature : 각각의 개발자가 기능을 개발하는 브랜치   
  - hotfix : 출시 버전에서 발생한 버그를 수정 하는 브랜치   


- (2) Commit Message Rules
  - Feat: 새로운 기능 추가
  - Fix: 버그 수정
  - Refactor: 코드 리팩토링
  - Remove: 파일 삭제
  - Docs: 문서 수정
  - test: 깃허브 기능 테스트를 위해 임의로 코드를 수정한 경우


- (3) Version 
  - 표기: V 1.0.0
    - 첫 번째: 이전 버전과 호환되지 않는 새로운 큰 변화가 있을 때
    - 두 번째: 기존 내용 및 기능은 유지한 채 새로운 기능이 추가되었을 때
    - 세 번째: 버그 수정, 코드 리팩토링, 누락 사항 수정 등으로 업데이트 되었을 때


# project info
- spring 2.6.5
- Java 11 (JDK 11)
- server: AWS EC2, RDS(set mysql), docker
  - API url (팀원 외 공유 금지): 
    http://54.180.133.245:8080//swagger-ui.html#/
