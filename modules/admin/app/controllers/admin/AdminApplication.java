package controllers.admin;

import play.mvc.Controller;
import play.mvc.Result;

public class AdminApplication extends Controller {

    public Result get() {

        return ok( "Admin application" );
    }

}
