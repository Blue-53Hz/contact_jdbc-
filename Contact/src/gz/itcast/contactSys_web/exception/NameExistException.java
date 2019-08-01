package gz.itcast.contactSys_web.exception;
/**
自定义异常
 * @author APPle
 *
 */
public class NameExistException extends Exception{

	public NameExistException(String msg){
		super(msg);
	}
}
