/**
 * Provides details about this component.
 */
public final class Component {

    /**
     * The current version of this component.
     * The placeholder will be replaced by the current version when the maven templating plugin is executed as part of the build.
     */
    public static final String CURRENT_VERSION = "0.0.1-SNAPSHOT";

    /**
     * The domain of the component.
     * The placeholder will be replaced by the current version when the maven templating plugin is executed as part of the build.
     */
    public static final String DOMAIN = "${domain}";

    private Component() {
    }
}
