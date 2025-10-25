# java-racingcar-precourse

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현할 기능 목록

1. InputView

- [x] 자동차 이름 입력받기
- [x] 시도 횟수 입력받기

2. Car

- [x] 자동차 클래스 생성
- [x] 자동차 위치 전진
- [x] 자동차 이름 및 위치 반환

3. CarList

- [ ] 여러 자동차 클래스 생성
- [ ] 여러 자동차 이동
- [ ] 우승자 반환

4. RunGame

- [ ] 단일 라운드 진행

4. RacingGameController

- [ ] 전체 게임 진행 (입력-게임 실행-출력)

4. InputValidator

- [x] 자동차 이름 검증
  - [x] 이름이 5자를 초과하는 경우 예외 발생
  - [x] 이름이 빈 문자열인 경우 예외 발생
  - [x] 이름이 중복되었을 경우 예외 발생
  - [x] 시도 횟수가 1 미만인 경우 예외 발생

5. OutputView

- [ ] 라운드별 실행 결과 출력
- [ ] 최종 우승자 출력

## 구조

```
main/java/racingcar/
├── controller
│   └── RacingGameController.java
├── model
│   ├── Car.java
│   ├── CarList.java
│   └── RunGame.java
├── view
│   ├── InputView.java
│   └── OutputView.java
├── utils
│   └── InputValidator.java
└── Application.java
```
