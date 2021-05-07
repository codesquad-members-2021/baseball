## baseball front-end

### 이전 프로젝트로부터 배운 점

- 데이지 : 컴포넌트를 디자인 요소를 나누어 파악하고 요소를 조합하는 과정을 통해 UI를 구성하도록 **아토믹 디자인** 패턴의 장점과 단점을 배웠습니다.
  - 장점 : 컴포넌트를 작은 단위로 나눠 조합하며 기능을 만들어 가기 때문에 컴포넌트를 재사용하여 디자인을 일관성 있게 통일할 수 있었습니다.
  - 단점 : Atoms, Molecules, Organisms, template, page 나누는 기준을 정하는게 어려웠습니다. Atom에서 부터 page가 만들어지기위해 거쳐야하는 컴포넌트 계층이 여러개이기 때문에 상태관리가 까다로웠습니다. 

  ![image](https://user-images.githubusercontent.com/13144573/117402089-b424a400-af40-11eb-9ae4-1df5c365d4a5.png)

- 빰빰 : 로직의 처리를 담당하는 컨테이너와 렌더를 담당하는 프레젠터 간 명확한 경계를 두어서 프로젝트를 진행하는 **컨테이너-프레젠테이셔널** 패턴의 장점과 단점을 배웠습니다.
  - 장점 : 컴포넌트를 로직단위와 렌더단위로 나눌 수 있어서 역할과 책임을 명확하게 할 수 있었습니다.
  - 단점 : props를 내려주는 것이 까다로운데, 훅스시대에 들어 훅스 활용이 해당 패턴을 대체했다는 것을 절절하게 배울 수 있었습니다.

  ![image](https://user-images.githubusercontent.com/13144573/117402182-e2a27f00-af40-11eb-9957-f8471e23885e.png)

- 지난 프로젝트에서 활용했던 패턴에 대한 회고 : 

  ![image](https://user-images.githubusercontent.com/13144573/117402500-7a07d200-af41-11eb-9b97-2555a6bade52.png)

  ![image](https://user-images.githubusercontent.com/13144573/117402636-bc311380-af41-11eb-9f54-ad53b32c13ab.png)

- 이번 프로젝트에서 활용할 방향

  - 기능 단위로 컴포넌트를 구성하자  
    ![image](https://user-images.githubusercontent.com/13144573/117402926-47aaa480-af42-11eb-9190-1f550cd8de9e.png)

  - [화면단위 컴포넌트 설계 자세히 보기](https://docs.google.com/presentation/d/17GzlcYPIwqRzOevI68n761RX7-3Yo5lIQd3g43VZFcY/edit?usp=sharing)  
    ![image](https://user-images.githubusercontent.com/13144573/117404668-4d55b980-af45-11eb-99af-e920c2104881.png)
    
  - [컴포넌트 구조 설계 자세히 보기](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1&title=baseball.front.drawio#R1Zpdb5swFIZ%2FDdJ2sSlgSOCy%2BeiH1Gid0LT20gMXvBGcOqYJ%2B%2FUzwYQQ045GIXaugg%2B2wc85x37tYIDJYnND4TKekxAlhjUINwaYGpZl2taQ%2FxSWvLS4plMaIopDUak2%2BPgvEsaBsGY4RKtGRUZIwvCyaQxImqKANWyQUrJuVnsmSfOpSxghyeAHMJGtP3HIYjEKa1TbbxGO4urJ5tAr7yxgVVmMZBXDkKz3TGBmgAklhJVXi80EJQW8ikvZ7vqNu7sXoyhlXRrc3f%2F4lUXf06fV6wt8Ac4c%2BdEXMYwVy6sBo5CPXxQJZTGJSAqTWW0dU5KlISp6HfBSXeeekCU3mtz4GzGWC2fCjBFuitkiEXfRBrPHveunoquvjihNN6LnbSGvCimj%2BeO2olkV99oVxbrhttRo%2BYAoXiCGqDCWwy7G%2BiZNYVqRjAboHYRVVEIaIfZOveHO5zxZEOFvQ3PejqIEMvzafA8oojba1asdyy%2BEbz%2FgZ9HvK0wy8aRb3vNDEfyHAdB07zrGDPlLuEWw5jnedKXoFlGGNu%2BTlEcuGgxFfuTN4rrONrNKoXgv06p6J0dVtNclJ0Zdk%2BJjKXHC6Lc6Rr%2BnMvotKfrnEKc6Rv9u3VMW%2FkBidQMX6jlZoAnK7sgJ9MXJvgxOrmpOzmVw2kFRBmoogZIgcQm5LC6DjCb5mMLgTzHn%2Fo9WjfZU7AZNdkBG10Zuh%2FP06kajJds6bsm2zrhmex3XbHPQHgZnkqxAH6ceqcO0dOobuX0ep3rSJDcnIUzULwf24S5EtQ6rhOAeqiliECd%2BQCjSg5oNtKMmb3QfEpgjeo9XTFNoI%2BXQZC3rk4AiHwUMk1Q5sUOtpn6TZMqqdpLRYjxltGlLzlNOTpa5tzw1Cc11ZQbU5%2BeodVLTFZjtdAQ26g2YLDNWKOG4xjDU4MzHkY48OwLrbQNlyWJDJ2DAPXIB6A%2BYrDN0AiZFWNc5rD9g8rliLcy04zXqmpG9nQZZsibTmZfy41hLVmSfjNnEcF3DmxizqeFdGW554Riea8zGhntleJzyYLuhMsD1Z%2B2wDltO1s6MVZZrZRgK0aYe2bFqrb%2BZrl2t7ZBpkcDAOxJbf3%2B7upcWaV33Uv1Fmixz9UZmK9dt1QtdwL8sjnkQby1fRrSxc3tjJ2tef%2FztLn0mygPtcDpr24K651w3gSWxmmK4IGl4jVES6gesZTI7LzB5f%2BAvKcegHJXt6hZbLVsDzIJ4nDGmwXGQxKu%2F0OLF%2BvvJ7b29r1DB7B8%3D)  
    ![image](https://user-images.githubusercontent.com/13144573/117404828-9443af00-af45-11eb-8b66-9cfa3656b62e.png)

---
### 이번 프로젝트에서 도전한 점

- 페어프로그래밍  
  - 5/4 프로젝트 구조 설정 페어프로그래밍
  - 5/5 CSS in JS 반응형 컴포넌트 구현 스터디 페어프로그래밍
  - 5/6 프로젝트 MainPage 엔트리포인트 구현 페어프로그래밍

- CSS in JS 에서의 스타일 관리

  - 지난 프로젝트로부터 회고했던 점은 다음과 같습니다.

    1) 지난 프로젝트에서 데이지와 스윙이 시도했던 atomic 단위의 체계적인 스타일 관리의 도입 가능성

    2) 지난 프로젝트에서 빰빰과 비모가 시도했던 엔트리포인트 단위의 컴포넌트 상속 관리의 도입 가능성

  - 이번 프로젝트에서 시도하는 방법은 다음과 같습니다.

    - commons에서 글로벌하게 적용되는 스타일드 컴포넌트를 체계적으로 관리해서 상속할 수 있도록 하자
    - [레퍼런스](https://thebook.io/080203/ch24/03/01/)

  - 이를 적용해보기 위해 어린이날에 안어린이들은 특정 주제를 갖고 스터디를 진행했습니다.

    - 반응형 디자인을 CSS in JS 스타일드 컴포넌트의 상속 형태로 어떻게 할 수 있을까.
    - [첫번째 프로젝트 주제였던 todo-list의 컬럼 구조를 반응형으로 변형해보기 repository](https://github.com/ppamppamman/study-responsive)

---
### 이번 프로젝트에서 도전할 점

### 데이지

- 경기 애니메이션 구현하기
  - 프로세스 개요  
    Pitch 버튼을 누른다 -> Pitch의 결과를 랜덤으로 정해서 상태를 저장한다. (Pitch 결과를 context로 관리)  
    -> 서버에 pitch데이터를 보내고 (안타 또는 out) 결과에 따라 캐릭터가 움직인다 (gif 사용 예정)

- 기능 구현 보다 리액트 구조 설계에 집중해서 구현해보기.
  - 반응형 디자인을 컴포넌트을 생성하는 Responsive 컴포넌트를 만들어 재사용 하기
  - Context API를 사용하여 글로벌 상태 관리하기
- 리액트 라우터 이해하고 라우터 만드는 방법 익혀보기.
- 빰빰과 뱃과 매일 10분씩 잡담하기. 잡담은 경쟁력!

### 빰빰

- 반응형 디자인을 공격적으로 적용한 프로젝트 작업하기

- 리액트 라우터를 사용하지 않고 라우터 만들기

- 게임 플레이 관련 애니메이션 프로세스 이해하기
  

---
### 프로젝트 간단 데모
![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/13144573/117411998-2f8d5200-af4f-11eb-886e-31ee84207f79.gif)
