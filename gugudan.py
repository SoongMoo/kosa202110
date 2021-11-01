while True:
	startDan = int(input("시작단을 입력해주세요. : "))
	endDan  = int(input("마지막단을 입력해주세요. : "))
	startGop  = int(input("시작곱을 입력해주세요. : "))
	endGop  = int(input("마지막곱을 입력해주세요. : "))
	dan = startDan
	while dan <= endDan:
		gop = startGop
		while gop <= endGop:
			print(f"{dan} * {gop} = {dan * gop}")
			gop += 1
		dan += 1
	stop = input("프로그램을 종료 하시려면 'Y'또는 'y'를 누르고 계소하려면 아무키나 ")
	if stop == 'Y' or stop == 'y':
		print("구구단 프로그램을 종료합니다.")
		break