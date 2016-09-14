package controllers.common;

import play.mvc.Controller;
import play.mvc.Result;


public class CommonApp extends Controller {

    public Result get() {
        return ok( "COMMON App" );
    }

}
