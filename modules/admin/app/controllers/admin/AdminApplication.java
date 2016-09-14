package controllers.admin;

import play.mvc.Controller;
import play.mvc.Result;

public class AdminApplication extends Controller {

    // routed from /modules/admin/conf/admin.routes file:

    public Result get() {

        return ok( views.html.admin.index.render("I'm a custom title here") );
    }

}
