package controllers.admin;

import com.google.inject.Inject;
import play.api.mvc.Action;
import play.api.mvc.AnyContent;

// documentation:
// https://www.playframework.com/documentation/2.5.x/SBTSubProjects#Assets-and-controller-classes-should-be-all-defined-in-the-controllers.admin-package

// check:
// https://luiscamilo.com/2015/07/27/play-framework-2-4-x-modulesub-project-assets/

// check admin.routes file with:
// GET        /assets/*file          controllers.admin.Assets.at(path="/public/lib/admin", file)

public class Assets {

    @Inject
    controllers.Assets assets;

    public Action<AnyContent> at(String path, String file) {

        return assets.at(path, file, false);
    }
}