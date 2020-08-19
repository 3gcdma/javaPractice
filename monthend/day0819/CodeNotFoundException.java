public class CodeNotFoundException extends RuntimeException {
	public CodeNotFoundException() {
		super("해당 상품번호가 존재하지 않습니다.");
	}
}
