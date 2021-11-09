
public class LoginMain {

	public static void main(String[] args) {
		LoginMember loginMember =
				new LoginMember("highland0","1234");
		int i = loginMember.login(args[0], args[1]);
		if(i == 1) {
			System.out.println("로그인 되었습니다.");
			loginMember.logout(args[0]);
		}else if(i == 0) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else if(i == -1) {
			System.out.println("존재하는 아이디가 없습니다.");
		}
	}

}
