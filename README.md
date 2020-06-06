# Algorithm 정리
---
## 1. 기본 알고리즘
* [정렬](#정렬)
>- [Bubble Sort](#bubble-sort)
>- [Counting Sort](#counting-sort)
* 정리를
---
## 2. JAVA 자료구조(알고리즘용)
* [Binary Search](#binary-search)
* 일단은
* 정리를
---
## 3. PYTHON 자료구조(알고리즘용)
* [뭐했더라?](#1day1commit)
* 일단은
* 정리를
---
## 4. 1day1commit
### 2020 1day 1commit
- 1월
>* 0101 17136_색종이붙이기
>* 0102 2606_바이러스
>* 0103 14502_연구소
>* 0104 14889_스타트와링크
>* 0105 1138_한줄로서기
>* 0106 1012_유기농배추
>* 0107 18232_텔레포트정거장
>* 0108 1261_알고스팟
>* 0109 2573_빙산
>* 0110 14620_꽃길
>* 0111 18242_네모네모시력검사
>* 0112 18228_펭귄추락대책위원회
>* 0113 18247_겨울왕국티켓예매
>* 0114 17945_통학의신 17946_피자는나눌수록커지잖아요
>* 0115 3985_롤케이크
>* 0116 17388_와글와글숭고한
>* 0118 17826_나의학점은
>* 0119 
>* 0120 
>* 0121 11048_이동하기
>* 0122
>* 0123 11722_가장긴감소하는부분수열
>* 0124
>* 0125
>* 0126
>* 0127
>* 0128
>* 0129
>* 0130
>* 0131
- 2월
>* 0201
>* 0202 자꾸 미뤄진게 많다...
>* 0203
>* 0204 
>* 0205
>* 0206
>* 0207
>* 0208
>* 0209
>* 0210
>* 0211
>* 0212
>* 0213
>* 0214
>* 0215
>* 0216
>* 0217
>* 0218
>* 0219
>* 0220
>* 0221
>* 0222
>* 0223
>* 0224
>* 0225
>* 0226
>* 0227
>* 0228
>* 0229
- 3월
>* 0301
>* 0302
>* 0303
>* 0304
>* 0305
>* 0306
>* 0307
>* 0308
>* 0309
>* 0310
>* 0311
>* 0312
>* 0313
>* 0314
>* 0315
>* 0316
>* 0317
>* 0318
>* 0319
>* 0320
>* 0321
>* 0322
>* 0323
>* 0324
>* 0325
>* 0326
>* 0327
>* 0328
>* 0329
>* 0330
>* 0331
- 4월
>* 0401
>* 0402
>* 0403
>* 0404
>* 0405
>* 0406
>* 0407
>* 0408
>* 0409
>* 0410
>* 0411
>* 0412
>* 0413
>* 0414
>* 0415
>* 0416
>* 0417
>* 0418
>* 0419
>* 0420
>* 0421
>* 0422
>* 0423
>* 0424
>* 0425
>* 0426
>* 0427
>* 0428
>* 0429
>* 0430
- 5월
>* 0501
>* 0502
>* 0503
>* 0504
>* 0505
>* 0506
>* 0507
>* 0508
>* 0509
>* 0510
>* 0511
>* 0512
>* 0513
>* 0514
>* 0515
>* 0516
>* 0517
>* 0518
>* 0519
>* 0520
>* 0521
>* 0522
>* 0523
>* 0524
>* 0525
>* 0526
>* 0527
>* 0528
>* 0529
>* 0530
>* 0531
- 6월
>* 0601
>* 0602
>* 0603
>* 0604
>* 0605
>* 0606

### 정렬

>#### Bubble Sort
>서로 인접한 두 원소를 검사하여 정렬하는 알고리즘
```java
private static void sort(int[] number) {
		int size = number.length,temp=0;
		for(int i=size-1; i>0; --i) {
			boolean isSwap = false;
			for(int j=0; j<i; ++j) {
				if(number[j]>number[j+1]) {
					temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
					isSwap = true;
				}
			}
			System.out.println("sort : "+Arrays.toString(number));
			if(!isSwap) break;
		}
	}
```
>#### Counting Sort
>

### Binary Search
> Arrays.binarySearch(배열, 값)을 사용한다.
> 찾는 값의 index를 반환하며 없는 경우 예상되는 위치의 -값을 반환한다.<반드시 정렬된 상태로 사용할 것!>
```java
	int[] values = {3,11,15,20,21,29};
	Arrays.sort(values);
	System.out.println(Arrays.toString(values));
	System.out.println(Arrays.binarySearch(values, 15));	//2반환
	System.out.println(Arrays.binarySearch(values, 20));	//3반환
	System.out.println(Arrays.binarySearch(values, 17));	//-4반환
```
		
### DisJointSet
```java
	private static int parents[];
	
	static void make() { // make set : 모든 원소를 개별적인 집합으로 생성
		Arrays.fill(parents, -1);
	}

	static int find(int a) {
		if(parents[a]<0) return a; // 자신이 루트이면 자신 리턴
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
```