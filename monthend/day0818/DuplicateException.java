public class DuplicateException extends RuntimeException {
	public DuplicateException() {
		super("상품이 이미 존재하고 있습니다.");
	}
}
