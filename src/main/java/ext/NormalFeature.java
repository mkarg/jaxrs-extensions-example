package ext;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * A sample feature NOT getting loaded automatically.
 * 
 * @author Markus KARG (markus@headcrashing.eu)
 */
public class NormalFeature implements Feature {

	@Override
	public boolean configure(FeatureContext context) {
		System.out.println("NormalFeature loaded");
		return true;
	}

}
