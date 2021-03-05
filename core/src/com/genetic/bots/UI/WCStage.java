package com.genetic.bots.UI;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.genetic.bots.InputHandler;
import com.genetic.bots.InputObserver;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WCStage extends Stage implements InputObserver {
    /**
     * Creates a stage with a {@link ScalingViewport} set to {@link Scaling#stretch}. The stage will use its own {@link Batch}
     * which will be disposed when the stage is disposed.
     */

    WorldCreating wc;
    public WCStage() {
        super();
        InputHandler.addToObservers(this);
    }

    public WCStage(WorldCreating worldCreating) {
        super();
        wc = worldCreating;
        InputHandler.addToObservers(this);
    }

    /**
     * Creates a stage with the specified viewport. The stage will use its own {@link Batch} which will be disposed when the stage
     * is disposed.
     *
     * @param viewport
     */
    public WCStage(Viewport viewport) {
        super(viewport);
    }

    /**
     * Creates a stage with the specified viewport and batch. This can be used to avoid creating a new batch (which can be
     * somewhat slow) if multiple stages are used during an application's life time.
     *
     * @param viewport
     * @param batch    Will not be disposed if {@link #dispose()} is called, handle disposal yourself.
     */
    public WCStage(Viewport viewport, Batch batch) {
        super(viewport, batch);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act() {
        super.act();
    }

    /**
     * Calls the {@link Actor#act(float)} method on each actor in the stage. Typically called each frame. This method also fires
     * enter and exit events.
     *
     * @param delta Time in seconds since the last frame.
     */
    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     * Applies a touch down event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the
     * event.
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return super.touchDown(screenX, Gdx.graphics.getHeight()-screenY, pointer, button);

    }

    /**
     * Applies a touch moved event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the
     * event. Only {@link InputListener listeners} that returned true for touchDown will receive this event.
     *
     * @param screenX
     * @param screenY
     * @param pointer
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, Gdx.graphics.getHeight()-screenY, pointer);
    }

    /**
     * Applies a touch up event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the event.
     * Only {@link InputListener listeners} that returned true for touchDown will receive this event.
     *
     * @param screenX
     * @param screenY
     * @param pointer
     * @param button
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return super.touchUp(screenX, Gdx.graphics.getHeight()-screenY, pointer, button);
    }

    /**
     * Applies a mouse moved event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the
     * event. This event only occurs on the desktop.
     *
     * @param screenX
     * @param screenY
     */
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    /**
     * Applies a mouse scroll event to the stage and returns true if an actor in the scene {@link Event#handle() handled} the
     * event. This event only occurs on the desktop.
     *
     * @param amount
     */
    @Override
    public boolean scrolled(int amount) {
        return super.scrolled(amount);
    }

    /**
     * Applies a key down event to the actor that has {@link Stage#setKeyboardFocus(Actor) keyboard focus}, if any, and returns
     * true if the event was {@link Event#handle() handled}.
     *
     * @param keyCode
     */
    @Override
    public boolean keyDown(int keyCode) {
        return super.keyDown(keyCode);
    }

    /**
     * Applies a key up event to the actor that has {@link Stage#setKeyboardFocus(Actor) keyboard focus}, if any, and returns true
     * if the event was {@link Event#handle() handled}.
     *
     * @param keyCode
     */
    @Override
    public boolean keyUp(int keyCode) {
        return super.keyUp(keyCode);
    }

    /**
     * Applies a key typed event to the actor that has {@link Stage#setKeyboardFocus(Actor) keyboard focus}, if any, and returns
     * true if the event was {@link Event#handle() handled}.
     *
     * @param character
     */
    @Override
    public boolean keyTyped(char character) {
        if(wc.name.getText().length()<16 || (int)character == 8) {
            return super.keyTyped(character);
        }
        else
            return false;
    }

    /**
     * Adds the listener to be notified for all touchDragged and touchUp events for the specified pointer and button. The actor
     * will be used as the {@link Event#getListenerActor() listener actor} and {@link Event#getTarget() target}.
     *
     * @param listener
     * @param listenerActor
     * @param target
     * @param pointer
     * @param button
     */
    @Override
    public void addTouchFocus(EventListener listener, Actor listenerActor, Actor target, int pointer, int button) {
        super.addTouchFocus(listener, listenerActor, target, pointer, button);
    }

    /**
     * Removes the listener from being notified for all touchDragged and touchUp events for the specified pointer and button. Note
     * the listener may never receive a touchUp event if this method is used.
     *
     * @param listener
     * @param listenerActor
     * @param target
     * @param pointer
     * @param button
     */
    @Override
    public void removeTouchFocus(EventListener listener, Actor listenerActor, Actor target, int pointer, int button) {
        super.removeTouchFocus(listener, listenerActor, target, pointer, button);
    }

    /**
     * Cancels touch focus for the specified actor.
     *
     * @param actor
     * @see #cancelTouchFocus()
     */
    @Override
    public void cancelTouchFocus(Actor actor) {
        super.cancelTouchFocus(actor);
    }

    /**
     * Sends a touchUp event to all listeners that are registered to receive touchDragged and touchUp events and removes their
     * touch focus. This method removes all touch focus listeners, but sends a touchUp event so that the state of the listeners
     * remains consistent (listeners typically expect to receive touchUp eventually). The location of the touchUp is
     * {@link Integer#MIN_VALUE}. Listeners can use {@link InputEvent#isTouchFocusCancel()} to ignore this event if needed.
     */
    @Override
    public void cancelTouchFocus() {
        super.cancelTouchFocus();
    }

    /**
     * Cancels touch focus for all listeners except the specified listener.
     *
     * @param exceptListener
     * @param exceptActor
     * @see #cancelTouchFocus()
     */
    @Override
    public void cancelTouchFocusExcept(EventListener exceptListener, Actor exceptActor) {
        super.cancelTouchFocusExcept(exceptListener, exceptActor);
    }

    /**
     * Adds an actor to the root of the stage.
     *
     * @param actor
     * @see Group#addActor(Actor)
     */
    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);
    }

    /**
     * Adds an action to the root of the stage.
     *
     * @param action
     * @see Group#addAction(Action)
     */
    @Override
    public void addAction(Action action) {
        super.addAction(action);
    }

    /**
     * Returns the root's child actors.
     *
     * @see Group#getChildren()
     */
    @Override
    public Array<Actor> getActors() {
        return super.getActors();
    }

    /**
     * Adds a listener to the root.
     *
     * @param listener
     * @see Actor#addListener(EventListener)
     */
    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(listener);
    }

    /**
     * Removes a listener from the root.
     *
     * @param listener
     * @see Actor#removeListener(EventListener)
     */
    @Override
    public boolean removeListener(EventListener listener) {
        return super.removeListener(listener);
    }

    /**
     * Adds a capture listener to the root.
     *
     * @param listener
     * @see Actor#addCaptureListener(EventListener)
     */
    @Override
    public boolean addCaptureListener(EventListener listener) {
        return super.addCaptureListener(listener);
    }

    /**
     * Removes a listener from the root.
     *
     * @param listener
     * @see Actor#removeCaptureListener(EventListener)
     */
    @Override
    public boolean removeCaptureListener(EventListener listener) {
        return super.removeCaptureListener(listener);
    }

    /**
     * Removes the root's children, actions, and listeners.
     */
    @Override
    public void clear() {
        super.clear();
    }

    /**
     * Removes the touch, keyboard, and scroll focused actors.
     */
    @Override
    public void unfocusAll() {
        super.unfocusAll();
    }

    /**
     * Removes the touch, keyboard, and scroll focus for the specified actor and any descendants.
     *
     * @param actor
     */
    @Override
    public void unfocus(Actor actor) {
        super.unfocus(actor);
    }

    @Override
    public boolean setKeyboardFocus(Actor actor) {
        return super.setKeyboardFocus(actor);
    }

    /**
     * Gets the actor that will receive key events.
     *
     * @return May be null.
     */
    @Override
    public Actor getKeyboardFocus() {
        return super.getKeyboardFocus();
    }

    /**
     * Sets the actor that will receive scroll events.
     *
     * @param actor May be null.
     * @return true if the unfocus and focus events were not cancelled by a {@link FocusListener}.
     */
    @Override
    public boolean setScrollFocus(Actor actor) {
        return super.setScrollFocus(actor);
    }

    /**
     * Gets the actor that will receive scroll events.
     *
     * @return May be null.
     */
    @Override
    public Actor getScrollFocus() {
        return super.getScrollFocus();
    }

    @Override
    public Batch getBatch() {
        return super.getBatch();
    }

    @Override
    public Viewport getViewport() {
        return super.getViewport();
    }

    @Override
    public void setViewport(Viewport viewport) {
        super.setViewport(viewport);
    }

    /**
     * The viewport's world width.
     */
    @Override
    public float getWidth() {
        return super.getWidth();
    }

    /**
     * The viewport's world height.
     */
    @Override
    public float getHeight() {
        return super.getHeight();
    }

    /**
     * The viewport's camera.
     */
    @Override
    public Camera getCamera() {
        return super.getCamera();
    }

    /**
     * Returns the root group which holds all actors in the stage.
     */
    @Override
    public Group getRoot() {
        return super.getRoot();
    }

    /**
     * Replaces the root group. Usually this is not necessary but a subclass may be desired in some cases, eg being notified of
     * .
     *
     * @param root
     */
    @Override
    public void setRoot(Group root) {
        super.setRoot(root);
    }

    /**
     * Returns the {@link Actor} at the specified location in stage coordinates. Hit testing is performed in the order the actors
     * were inserted into the stage, last inserted actors being tested first. To get stage coordinates from screen coordinates, use
     * {@link #screenToStageCoordinates(Vector2)}.
     *
     * @param stageX
     * @param stageY
     * @param touchable If true, the hit detection will respect the {@link Actor#setTouchable(Touchable) touchability}.
     * @return May be null if no actor was hit.
     */
    @Override
    public Actor hit(float stageX, float stageY, boolean touchable) {
        return super.hit(stageX, stageY, touchable);
    }

    /**
     * Transforms the screen coordinates to stage coordinates.
     *
     * @param screenCoords Input screen coordinates and output for resulting stage coordinates.
     */
    @Override
    public Vector2 screenToStageCoordinates(Vector2 screenCoords) {
        return super.screenToStageCoordinates(screenCoords);
    }

    /**
     * Transforms the stage coordinates to screen coordinates.
     *
     * @param stageCoords Input stage coordinates and output for resulting screen coordinates.
     */
    @Override
    public Vector2 stageToScreenCoordinates(Vector2 stageCoords) {
        return super.stageToScreenCoordinates(stageCoords);
    }

    /**
     * Transforms the coordinates to screen coordinates. The coordinates can be anywhere in the stage since the transform matrix
     * describes how to convert them. The transform matrix is typically obtained from {@link Batch#getTransformMatrix()} during
     * {@link Actor#draw(Batch, float)}.
     *
     * @param coords
     * @param transformMatrix
     * @see Actor#localToStageCoordinates(Vector2)
     */
    @Override
    public Vector2 toScreenCoordinates(Vector2 coords, Matrix4 transformMatrix) {
        return super.toScreenCoordinates(coords, transformMatrix);
    }

    /**
     * Calculates window scissor coordinates from local coordinates using the batch's current transformation matrix.
     *
     * @param localRect
     * @param scissorRect
     */
    @Override
    public void calculateScissors(Rectangle localRect, Rectangle scissorRect) {
        super.calculateScissors(localRect, scissorRect);
    }

    /**
     * If true, any actions executed during a call to {@link #act()}) will result in a call to {@link Graphics#requestRendering()}
     * . Widgets that animate or otherwise require additional rendering may check this setting before calling
     * {@link Graphics#requestRendering()}. Default is true.
     *
     * @param actionsRequestRendering
     */
    @Override
    public void setActionsRequestRendering(boolean actionsRequestRendering) {
        super.setActionsRequestRendering(actionsRequestRendering);
    }

    @Override
    public boolean getActionsRequestRendering() {
        return super.getActionsRequestRendering();
    }

    /**
     * The default color that can be used by actors to draw debug lines.
     */
    @Override
    public Color getDebugColor() {
        return super.getDebugColor();
    }

    /**
     * If true, debug lines are shown for actors even when {@link Actor#isVisible()} is false.
     *
     * @param debugInvisible
     */
    @Override
    public void setDebugInvisible(boolean debugInvisible) {
        super.setDebugInvisible(debugInvisible);
    }

    /**
     * If true, debug lines are shown for all actors.
     *
     * @param debugAll
     */
    @Override
    public void setDebugAll(boolean debugAll) {
        super.setDebugAll(debugAll);
    }

    @Override
    public boolean isDebugAll() {
        return super.isDebugAll();
    }

    /**
     * If true, debug is enabled only for the actor under the mouse. Can be combined with {@link #setDebugAll(boolean)}.
     *
     * @param debugUnderMouse
     */
    @Override
    public void setDebugUnderMouse(boolean debugUnderMouse) {
        super.setDebugUnderMouse(debugUnderMouse);
    }

    /**
     * If true, debug is enabled only for the parent of the actor under the mouse. Can be combined with
     * {@link #setDebugAll(boolean)}.
     *
     * @param debugParentUnderMouse
     */
    @Override
    public void setDebugParentUnderMouse(boolean debugParentUnderMouse) {
        super.setDebugParentUnderMouse(debugParentUnderMouse);
    }

    /**
     * If not {@link Table.Debug#none}, debug is enabled only for the first ascendant of the actor under the mouse that is a table. Can
     * be combined with {@link #setDebugAll(boolean)}.
     *
     * @param debugTableUnderMouse May be null for {@link Table.Debug#none}.
     */
    @Override
    public void setDebugTableUnderMouse(Table.Debug debugTableUnderMouse) {
        super.setDebugTableUnderMouse(debugTableUnderMouse);
    }

    /**
     * If true, debug is enabled only for the first ascendant of the actor under the mouse that is a table. Can be combined with
     * {@link #setDebugAll(boolean)}.
     *
     * @param debugTableUnderMouse
     */
    @Override
    public void setDebugTableUnderMouse(boolean debugTableUnderMouse) {
        super.setDebugTableUnderMouse(debugTableUnderMouse);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Check if screen coordinates are inside the viewport's screen area.
     *
     * @param screenX
     * @param screenY
     */
    @Override
    protected boolean isInsideViewport(int screenX, int screenY) {
        return super.isInsideViewport(screenX, screenY);
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.  Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java&trade; virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     * @jls 12.6 Finalization of Class Instances
     * @see WeakReference
     * @see PhantomReference
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
