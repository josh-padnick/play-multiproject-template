package controllers.common;
import play.api.mvc.*;
import play.api.mvc.AnyContent;

public class Assets {
  
  public static Action<AnyContent> at(String path, String file) {
     return controllers.Assets.at(path, file, false);
  }
  
}
