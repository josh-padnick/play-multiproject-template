package controllers.admin;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    public static Result getIndex() {
        return ok( views.html.admin.index.render( "Hello, " + models.admin.MyLibrary.getName() + ". Welcome to Play Framework." ) );
    }

}
