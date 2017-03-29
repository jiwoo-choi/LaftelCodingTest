# LaftelCodingTest
라프텔 코딩테스트진행


1. likes message
문자열 배열을 받아서, “~~ likes it” 문구로 바꾸세요.
예시)
likes([])
likes(["Rafy"])
likes(["Rafy", "Ryan"])
likes(["Rafy", "Ryan", "Curian"])
likes(["Rafy", "Ryan", "Curian", "Billy"]) likes(["Rafy", "Ryan", "Curian", "Billy", "Green"])
// "no one likes this"
// "Rafy likes this"
// "Rafy and Ryan like this"
// "Rafy, Ryan and Curian like this" // "Rafy, Ryan and 2 others like this" // "Rafy, Ryan and 3 others like this"

2. Reverse with tag
HTML 태그가 포함된 문자열을 받아서, 전체 문장을 뒤집으세요. 단, 태그는 모두 그대로 적용되어야 합니다.
예시)
원문: "The quick <font color="brown">brown</font> fox jumps over the lazy dog" 결과: "god yzal eht revo spmuj xof <font color="brown">nworb</font> kciuq ehT"

3. Poker hand
5개의 카드 표기로 이루어진 문자열 두 개를 받아서, 승/패/무승부를 판별하세요. (포커 규칙을 모르는 분을 위해서 마지막 장에 설명을 적어 놓았습니다.)
카드 표기는 한 장의 카드를 두 글자로 표기하며, 공백( )으로 구분된 5장의 카드가 주어집니다.
예시)
Player1("As 8d Ad 8c 5d"), Player2("Qh Qs Jd Kd Jc") : Player1 win Player1("Ks Kc Jd Kd Jc"), Player2("Jh Js Jd Kd Jc") : Player2 win Player1("Ad Kh Ac 7h 7d"), Player2("Ah Kh Ac 7h 7d") : Draw
부록: 포커 규칙에 대해서
카드 한 장은 아래와 같은 순서대로 값이 높아집니다.
2, 3, 4, 5, 6, 7, 8, 9, T(10), J(Jack), Q(Queen), K(King), A(Ace)
무늬는 높고 낮음이 없으며, 다음 4가지 소문자로 표시되어 있습니다. c(Club-♣),d(Diamond- ♦),h(Heart- ♥),s(Spade- ♠)
예시)
As : Ace of Spade
Td : Ten of Diamonds 8c : Eight of Clubs
다섯 장으로 이루어진 패의 계급은, 낮은 것부터 높은 순서로 아래와 같습니다.
- High Card
- One Pair
- Two Pairs
- Three of a Kind
- Straight
- Flush
- Full House
- Four of a Kind
- Straight Flush
- Royal Flush
: 가장 높은 카드 순서로 비교. : 한 쌍이 같은 카드.
: 서로 다른 두 쌍이 같은 카드. : 세 장이 같은 카드.
: 모든 카드가 연속된 숫자. (A는 1도 되고, K 뒤에 올 수 있음) : 모든 카드의 무늬가 같음.
: 세 장이 같고, 또 한 쌍이 같음 (ThreeofaKind+OnePair). : 네 장이 같은 카드.
: 모든 카드가 연속된 숫자이면서 무늬도 같음. :10,J,Q,K,A가 무늬도 같음.
두 사람의 패가 같은 계급이라면, 계급을 구성하는 카드 중 높은 쪽을 쥔 사람이 이깁니다. 예를 들면,
- 8 One Pair는 5 One Pair를 이깁니다.
- K Full House(K-K-K-8-8)는 Q Full House(Q-Q-Q-A-A)를 이깁니다.
- A High Flush(Ac-Jc-8c-6c-4c)는 K High Flush(Kc-Qc-Jc-8c-6c)을 이깁니다.
- Straight의 경우, A High Straight(A-K-Q-J-T)는 8 High Straight(8-7-6-5-4)에 이기지만,
- 예외적으로 5 High Straight(5-4-3-2-1)에서 Ace는 가장 낮은 카드로 간주되어,
8 High Straight(8-7-6-5-4)에 집니다.
계급을 이루는 카드 숫자까지 같으면, 다른 카드를 높은 순서대로 비교해서 승부를 정합니다.
- 같은 K Full House라면, (K-K-K-8-8) (K-K-K-6-6)을 이깁니다.
- 같은 A Three of a Kind 라면, (A-A-A-Q-8)은 (A-A-A-Q-6)을 이깁니다.
- A High Flush 끼리라면, (Ac-Jc-8c-6c-4c)가 (Ac-9c-8c-6c-4c)을 이깁니다.
