package ca.corbett.musicplayer.extensions.template;

import ca.corbett.extensions.AppExtension;
import ca.corbett.musicplayer.Actions;
import ca.corbett.musicplayer.audio.AudioMetadata;
import ca.corbett.musicplayer.ui.AppTheme;
import ca.corbett.musicplayer.ui.LyricsEditDialog;
import ca.corbett.musicplayer.ui.TrackInfoDialog;
import ca.corbett.musicplayer.ui.VisualizationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A starting point for extensions within the MusicPlayer app.
 * Modify as described in the README, using the javadocs on each
 * method as a guide to what you can implement.
 */
public abstract class ExtensionTemplate extends AppExtension {

    /**
     * Override this method if your extension provides custom
     * actions for the media player. These will be inserted into
     * the toolbar at the bottom of the media player. Note that you
     * have to supply the resource path of an image icon to be
     * used for the button. You can bundle a 48x48 icon in your
     * jar's resources and pass the resource location to
     * your MPAction. See the MPAction class javadocs
     * for an example, and refer to the icons bundled with
     * the musicplayer base jar for icon examples.
     *
     * @return A List of MPActions. A null or empty list will be ignored.
     */
    public List<Actions.MPAction> getMediaPlayerActions() {
        return new ArrayList<>();
    }

    /**
     * Override this method if your extension provides custom
     * actions for the playlist. These will be inserted into the
     * toolbar at the bottom of the playlist view.  Note that you
     * have to supply the resource path of an image icon to be
     * used for the button. You can bundle a 48x48 icon in your
     * jar's resources and pass the resource location to
     * your MPAction. See the MPAction class javadocs
     * for an example, and refer to the icons bundled with
     * the musicplayer base jar for icon examples.
     *
     * @return A List of MPActions. A null or empty list will be ignored.
     */
    public List<Actions.MPAction> getPlaylistActions() {
        return new ArrayList<>();
    }

    /**
     * Allows the extension to supply a list of custom application themes
     * that the user can choose from in AppConfig. An empty list is
     * returned by default, indicating no custom themes.
     *
     * @return a List of application themes supplied by this extension
     */
    public List<AppTheme.Theme> getCustomThemes() {
        return new ArrayList<>();
    }

    /**
     * Allows the extension to supply a custom Visualizer for full-screen
     * visualization of tracks.
     *
     * @return A List of Visualizer instances. Might be empty.
     */
    public List<VisualizationManager.Visualizer> getCustomVisualizers() {
        // If your extension supplies a custom Visualizer, supply it here, like this:
        //return List.of(new ExtensionVisualizer());

        // Or return an empty list if you don't have any custom visualizers:
        return new ArrayList<>();
    }

    /**
     * Returns a TrackInfoDialog (or some derived instance) for the given
     * File, if this extension is capable of displaying detailed track
     * information for an audio file.
     *
     * @param metadata The metadata for the track to be displayed.
     * @return a TrackInfoDialog instance, or null if this extension doesn't supply one.
     */
    public TrackInfoDialog getTrackInfoDialog(AudioMetadata metadata) {
        return null;
    }

    /**
     * Returns a LyricsEditDialog (or some derived instance) for the given
     * AudioMetadata, if this extension is capable of displaying a lyrics editor.
     *
     * @param metadata The metadata for the track to be edited.
     * @return a LyricsEditDialog instance, or null if this extension doesn't supply one.
     */
    public LyricsEditDialog getLyricsEditDialog(AudioMetadata metadata) {
        return null;
    }
}
