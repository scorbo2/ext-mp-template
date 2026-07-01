package ca.corbett.musicplayer.extensions.template;

import ca.corbett.extensions.AppExtension;
import ca.corbett.extensions.AppExtensionInfo;
import ca.corbett.extras.properties.AbstractProperty;
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
public class ExtensionTemplate extends AppExtension {

    private final AppExtensionInfo extInfo;

    /**
     * We must supply a no-arg constructor, as that's what the application expects.
     * Best practice here is to verify that we can load our bundled extInfo.json file,
     * and throw a RuntimeException if we can't, as that indicates a problem with the extension jar.
     */
    public ExtensionTemplate() {
        extInfo = AppExtensionInfo.fromExtensionJar(getClass(), "/extInfo.json");
        if (extInfo == null) {
            throw new RuntimeException("ExtensionTemplate: can't parse extInfo.json from jar resources!");
        }
    }

    /**
     * The application will query this method to get the extension's metadata, which is stored in extInfo.json.
     * Be sure to edit the template extInfo.json file to provide information about your extension!
     */
    @Override
    public AppExtensionInfo getInfo() {
        return extInfo;
    }

    /**
     * If your application needs to supply configuration properties for the user to modify, you can supply
     * a list of them here. An empty list is perfectly fine, if you have no config properties to expose.
     */
    @Override
    protected List<AbstractProperty> createConfigProperties() {
        return List.of();
    }

    /**
     * If you need to load images, icons, sound effects, or any other resources from your bundled jar file,
     * you must do that here. The class loader that loads your jar file will be closed after this method
     * is invoked, so you won't get another chance to load them later. This method is invoked exactly
     * once, immediately after your extension is instantiated.
     */
    @Override
    protected void loadJarResources() {
    }

    /**
     * Invoked by the application either as the application is starting up, or when the
     * extension is enabled within the application. After this method is invoked, your extension
     * is "active" and your other extension methods may be invoked by the application.
     */
    public void onActivate() {
    }

    /**
     * Invoked either as the application is shutting down, or when the
     * extension is disabled within the application. After this method is invoked, your extension
     * is no longer "active", and your other extension methods will no longer be invoked.
     */
    public void onDeactivate() {
    }


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
        //return List.of(new VisualizerTemplate());

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
