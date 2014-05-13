package controllers.customer;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Author: Josh Padnick
 * Company: Omedix, Inc.
 * Date: 5/11/14 at 5:44 PM
 */
public class Application extends Controller {

    public static Result getPage1() {
        return ok( views.html.customer.subfolder.page.render() );
    }

}
