package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

    // Put "Application-level" controllers here (e.g. retrieve the git SHA of the currently deployed version)

    public static Result getCurrentlyDeployedGitSHA() {
         return ok( "Somehow get your git SHA; for example, you might read it from a file on your local file system." );
    }

}
