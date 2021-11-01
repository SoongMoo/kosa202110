import random
icnt = int(input("구매수량을 입력하시오 : "))
y = 1
while y <= icnt:
	lotto = []
	i = 1
	while i <= 45:
		lotto.append(i)
		i += 1
	cnt = 1
	lottonum =""
	while cnt <= 6:
		listSize = len(lotto) -1
		idx = random.randint(0, listSize)
		num = lotto.pop(idx)
		lottonum += str(num) +", "
		cnt += 1
	print(lottonum.rstrip(", "))
	y += 1;	