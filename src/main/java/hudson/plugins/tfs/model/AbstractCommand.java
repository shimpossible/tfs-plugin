package hudson.plugins.tfs.model;

import hudson.model.AbstractProject;
import jenkins.util.TimeDuration;
import net.sf.json.JSONObject;

public abstract class AbstractCommand {

    public AbstractCommand() {
    }

    public interface Factory {
        AbstractCommand create();
        String getSampleRequestPayload();
    }

    /**
     * Actually do the work of the command, using the supplied
     * {@code requestPayload} and returning the output as a {@link JSONObject}.
     *
     * @param project an {@link AbstractProject to operate on}
     * @param requestPayload a {@link JSONObject} representing the command's input
     * @param delay how long to wait before the project starts executing
     *
     * @return a {@link JSONObject} representing the hook event's output
     */
    public abstract JSONObject perform(final AbstractProject project, final JSONObject requestPayload, final TimeDuration delay);
}
