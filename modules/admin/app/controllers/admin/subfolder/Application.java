package controllers.admin.subfolder;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result test1() {
        return ok("Hello");
    }

    public static Result test2() {
        return play.mvc.Results.TODO;
    }
}
