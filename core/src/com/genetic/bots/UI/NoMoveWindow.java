package com.genetic.bots.UI;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.ScissorStack;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.SnapshotArray;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NoMoveWindow extends Window {
    public NoMoveWindow(String title, Skin skin) {
        super(title, skin);
    }

    public NoMoveWindow(String title, Skin skin, String styleName) {
        super(title, skin, styleName);
    }

    public NoMoveWindow(String title, WindowStyle style) {
        super(title, style);
    }

    @Override
    public void setStyle(WindowStyle style) {
        super.setStyle(style);
    }

    /**
     * Returns the window's style. Modifying the returned style may not have an effect until {@link #setStyle(WindowStyle)} is
     * called.
     */
    @Override
    public WindowStyle getStyle() {
        return super.getStyle();
    }

    @Override
    public void keepWithinStage() {
        super.keepWithinStage();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    protected void drawStageBackground(Batch batch, float parentAlpha, float x, float y, float width, float height) {
        super.drawStageBackground(batch, parentAlpha, x, y, width, height);
    }

    @Override
    protected void drawBackground(Batch batch, float parentAlpha, float x, float y) {
        super.drawBackground(batch, parentAlpha, x, y);
    }

    @Override
    public Actor hit(float x, float y, boolean touchable) {
        return null;
    }

    @Override
    public boolean isMovable() {
        return super.isMovable();
    }

    @Override
    public void setMovable(boolean isMovable) {
        super.setMovable(isMovable);
    }

    @Override
    public boolean isModal() {
        return super.isModal();
    }

    @Override
    public void setModal(boolean isModal) {
        super.setModal(isModal);
    }

    @Override
    public void setKeepWithinStage(boolean keepWithinStage) {
        super.setKeepWithinStage(keepWithinStage);
    }

    @Override
    public boolean isResizable() {
        return super.isResizable();
    }

    @Override
    public void setResizable(boolean isResizable) {
        super.setResizable(isResizable);
    }

    @Override
    public void setResizeBorder(int resizeBorder) {
        super.setResizeBorder(resizeBorder);
    }

    @Override
    public boolean isDragging() {
        return false;
    }

    @Override
    public float getPrefWidth() {
        return super.getPrefWidth();
    }

    @Override
    public Table getTitleTable() {
        return super.getTitleTable();
    }

    @Override
    public Label getTitleLabel() {
        return super.getTitleLabel();
    }

    /**
     * Sets the background drawable from the skin and adjusts the table's padding to match the background. This may only be called
     * if {@link Table#Table(Skin)} or {@link #setSkin(Skin)} was used.
     *
     * @param drawableName
     * @see #setBackground(Drawable)
     */
    @Override
    public void setBackground(String drawableName) {
        super.setBackground(drawableName);
    }

    /**
     * @param background May be null to clear the background.
     */
    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
    }

    /**
     * @param background
     * @see #setBackground(Drawable)
     */
    @Override
    public Table background(Drawable background) {
        return super.background(background);
    }

    /**
     * @param drawableName
     * @see #setBackground(String)
     */
    @Override
    public Table background(String drawableName) {
        return super.background(drawableName);
    }

    @Override
    public Drawable getBackground() {
        return super.getBackground();
    }

    /**
     * Causes the contents to be clipped if they exceed the table actor's bounds. Enabling clipping will set
     * {@link #setTransform(boolean)} to true.
     *
     * @param enabled
     */
    @Override
    public void setClip(boolean enabled) {
        super.setClip(enabled);
    }

    @Override
    public boolean getClip() {
        return super.getClip();
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    /**
     * Adds a new cell to the table with the specified actor.
     *
     * @param actor
     */
    @Override
    public <T extends Actor> Cell<T> add(T actor) {
        return super.add(actor);
    }

    @Override
    public void add(Actor... actors) {
        super.add(actors);
    }

    /**
     * Adds a new cell with a label. This may only be called if {@link Table#Table(Skin)} or {@link #setSkin(Skin)} was used.
     *
     * @param text
     */
    @Override
    public Cell<Label> add(CharSequence text) {
        return super.add(text);
    }

    /**
     * Adds a new cell with a label. This may only be called if {@link Table#Table(Skin)} or {@link #setSkin(Skin)} was used.
     *
     * @param text
     * @param labelStyleName
     */
    @Override
    public Cell<Label> add(CharSequence text, String labelStyleName) {
        return super.add(text, labelStyleName);
    }

    /**
     * Adds a new cell with a label. This may only be called if {@link Table#Table(Skin)} or {@link #setSkin(Skin)} was used.
     *
     * @param text
     * @param fontName
     * @param color
     */
    @Override
    public Cell<Label> add(CharSequence text, String fontName, Color color) {
        return super.add(text, fontName, color);
    }

    /**
     * Adds a new cell with a label. This may only be called if {@link Table#Table(Skin)} or {@link #setSkin(Skin)} was used.
     *
     * @param text
     * @param fontName
     * @param colorName
     */
    @Override
    public Cell<Label> add(CharSequence text, String fontName, String colorName) {
        return super.add(text, fontName, colorName);
    }

    /**
     * Adds a cell without an actor.
     */
    @Override
    public Cell add() {
        return super.add();
    }

    /**
     * Adds a new cell to the table with the specified actors in a {@link Stack}.
     *
     * @param actors May be null to add a stack without any actors.
     */
    @Override
    public Cell<Stack> stack(Actor... actors) {
        return super.stack(actors);
    }

    @Override
    public boolean removeActor(Actor actor) {
        return super.removeActor(actor);
    }

    @Override
    public boolean removeActor(Actor actor, boolean unfocus) {
        return super.removeActor(actor, unfocus);
    }

    /**
     * Removes all actors and cells from the table.
     */
    @Override
    public void clearChildren() {
        super.clearChildren();
    }

    /**
     * Removes all actors and cells from the table (same as {@link #clearChildren()}) and additionally resets all table properties
     * and cell, column, and row defaults.
     */
    @Override
    public void reset() {
        super.reset();
    }

    /**
     * Indicates that subsequent cells should be added to a new row and returns the cell values that will be used as the defaults
     * for all cells in the new row.
     */
    @Override
    public Cell row() {
        return super.row();
    }

    /**
     * Gets the cell values that will be used as the defaults for all cells in the specified column. Columns are indexed starting
     * at 0.
     *
     * @param column
     */
    @Override
    public Cell columnDefaults(int column) {
        return super.columnDefaults(column);
    }

    /**
     * Returns the cell for the specified actor in this table, or null.
     *
     * @param actor
     */
    @Override
    public <T extends Actor> Cell<T> getCell(T actor) {
        return super.getCell(actor);
    }

    /**
     * Returns the cells for this table.
     */
    @Override
    public Array<Cell> getCells() {
        return super.getCells();
    }

    @Override
    public float getPrefHeight() {
        return super.getPrefHeight();
    }

    @Override
    public float getMinWidth() {
        return super.getMinWidth();
    }

    @Override
    public float getMinHeight() {
        return super.getMinHeight();
    }

    /**
     * The cell values that will be used as the defaults for all cells.
     */
    @Override
    public Cell defaults() {
        return super.defaults();
    }

    /**
     * Sets the padTop, padLeft, padBottom, and padRight around the table to the specified value.
     *
     * @param pad
     */
    @Override
    public Table pad(Value pad) {
        return super.pad(pad);
    }

    @Override
    public Table pad(Value top, Value left, Value bottom, Value right) {
        return super.pad(top, left, bottom, right);
    }

    /**
     * Padding at the top edge of the table.
     *
     * @param padTop
     */
    @Override
    public Table padTop(Value padTop) {
        return super.padTop(padTop);
    }

    /**
     * Padding at the left edge of the table.
     *
     * @param padLeft
     */
    @Override
    public Table padLeft(Value padLeft) {
        return super.padLeft(padLeft);
    }

    /**
     * Padding at the bottom edge of the table.
     *
     * @param padBottom
     */
    @Override
    public Table padBottom(Value padBottom) {
        return super.padBottom(padBottom);
    }

    /**
     * Padding at the right edge of the table.
     *
     * @param padRight
     */
    @Override
    public Table padRight(Value padRight) {
        return super.padRight(padRight);
    }

    /**
     * Sets the padTop, padLeft, padBottom, and padRight around the table to the specified value.
     *
     * @param pad
     */
    @Override
    public Table pad(float pad) {
        return super.pad(pad);
    }

    @Override
    public Table pad(float top, float left, float bottom, float right) {
        return super.pad(top, left, bottom, right);
    }

    /**
     * Padding at the top edge of the table.
     *
     * @param padTop
     */
    @Override
    public Table padTop(float padTop) {
        return super.padTop(padTop);
    }

    /**
     * Padding at the left edge of the table.
     *
     * @param padLeft
     */
    @Override
    public Table padLeft(float padLeft) {
        return super.padLeft(padLeft);
    }

    /**
     * Padding at the bottom edge of the table.
     *
     * @param padBottom
     */
    @Override
    public Table padBottom(float padBottom) {
        return super.padBottom(padBottom);
    }

    /**
     * Padding at the right edge of the table.
     *
     * @param padRight
     */
    @Override
    public Table padRight(float padRight) {
        return super.padRight(padRight);
    }

    /**
     * Alignment of the logical table within the table actor. Set to , {@link Align#top}, {@link Align#bottom}
     * , {@link Align#left}, {@link Align#right}, or any combination of those.
     *
     * @param align
     */
    @Override
    public Table align(int align) {
        return super.align(align);
    }

    /**
     * Sets the alignment of the logical table within the table actor to {@link Align#center}. This clears any other alignment.
     */
    @Override
    public Table center() {
        return super.center();
    }

    /**
     * Adds {@link Align#top} and clears {@link Align#bottom} for the alignment of the logical table within the table actor.
     */
    @Override
    public Table top() {
        return super.top();
    }

    /**
     * Adds {@link Align#left} and clears {@link Align#right} for the alignment of the logical table within the table actor.
     */
    @Override
    public Table left() {
        return super.left();
    }

    /**
     * Adds {@link Align#bottom} and clears {@link Align#top} for the alignment of the logical table within the table actor.
     */
    @Override
    public Table bottom() {
        return super.bottom();
    }

    /**
     * Adds {@link Align#right} and clears {@link Align#left} for the alignment of the logical table within the table actor.
     */
    @Override
    public Table right() {
        return super.right();
    }

    @Override
    public void setDebug(boolean enabled) {
        super.setDebug(enabled);
    }

    @Override
    public Table debug() {
        return super.debug();
    }

    @Override
    public Table debugAll() {
        return super.debugAll();
    }

    /**
     * Turns on table debug lines.
     */
    @Override
    public Table debugTable() {
        return super.debugTable();
    }

    /**
     * Turns on cell debug lines.
     */
    @Override
    public Table debugCell() {
        return super.debugCell();
    }

    /**
     * Turns on actor debug lines.
     */
    @Override
    public Table debugActor() {
        return super.debugActor();
    }

    /**
     * Turns debug lines on or off.
     *
     * @param debug
     */
    @Override
    public Table debug(Debug debug) {
        return super.debug(debug);
    }

    @Override
    public Debug getTableDebug() {
        return super.getTableDebug();
    }

    @Override
    public Value getPadTopValue() {
        return super.getPadTopValue();
    }

    @Override
    public float getPadTop() {
        return super.getPadTop();
    }

    @Override
    public Value getPadLeftValue() {
        return super.getPadLeftValue();
    }

    @Override
    public float getPadLeft() {
        return super.getPadLeft();
    }

    @Override
    public Value getPadBottomValue() {
        return super.getPadBottomValue();
    }

    @Override
    public float getPadBottom() {
        return super.getPadBottom();
    }

    @Override
    public Value getPadRightValue() {
        return super.getPadRightValue();
    }

    @Override
    public float getPadRight() {
        return super.getPadRight();
    }

    /**
     * Returns {@link #getPadLeft()} plus {@link #getPadRight()}.
     */
    @Override
    public float getPadX() {
        return super.getPadX();
    }

    /**
     * Returns {@link #getPadTop()} plus {@link #getPadBottom()}.
     */
    @Override
    public float getPadY() {
        return super.getPadY();
    }

    @Override
    public int getAlign() {
        return super.getAlign();
    }

    /**
     * Returns the row index for the y coordinate, or -1 if there are no cells.
     *
     * @param y The y coordinate, where 0 is the top of the table.
     */
    @Override
    public int getRow(float y) {
        return super.getRow(y);
    }

    @Override
    public void setSkin(Skin skin) {
        super.setSkin(skin);
    }

    /**
     * If true (the default), positions and sizes are rounded to integers.
     *
     * @param round
     */
    @Override
    public void setRound(boolean round) {
        super.setRound(round);
    }

    @Override
    public int getRows() {
        return super.getRows();
    }

    @Override
    public int getColumns() {
        return super.getColumns();
    }

    /**
     * Returns the height of the specified row, or 0 if the table layout has not been validated.
     *
     * @param rowIndex
     */
    @Override
    public float getRowHeight(int rowIndex) {
        return super.getRowHeight(rowIndex);
    }

    /**
     * Returns the min height of the specified row.
     *
     * @param rowIndex
     */
    @Override
    public float getRowMinHeight(int rowIndex) {
        return super.getRowMinHeight(rowIndex);
    }

    /**
     * Returns the pref height of the specified row.
     *
     * @param rowIndex
     */
    @Override
    public float getRowPrefHeight(int rowIndex) {
        return super.getRowPrefHeight(rowIndex);
    }

    /**
     * Returns the width of the specified column, or 0 if the table layout has not been validated.
     *
     * @param columnIndex
     */
    @Override
    public float getColumnWidth(int columnIndex) {
        return super.getColumnWidth(columnIndex);
    }

    /**
     * Returns the min height of the specified column.
     *
     * @param columnIndex
     */
    @Override
    public float getColumnMinWidth(int columnIndex) {
        return super.getColumnMinWidth(columnIndex);
    }

    /**
     * Returns the pref height of the specified column.
     *
     * @param columnIndex
     */
    @Override
    public float getColumnPrefWidth(int columnIndex) {
        return super.getColumnPrefWidth(columnIndex);
    }

    @Override
    public void layout() {
        super.layout();
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        super.drawDebug(shapes);
    }

    @Override
    protected void drawDebugBounds(ShapeRenderer shapes) {
        super.drawDebugBounds(shapes);
    }

    /**
     * @return The skin that was passed to this table in its constructor, or null if none was given.
     */
    @Override
    public Skin getSkin() {
        return super.getSkin();
    }

    @Override
    public float getMaxWidth() {
        return super.getMaxWidth();
    }

    @Override
    public float getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override
    public void setLayoutEnabled(boolean enabled) {
        super.setLayoutEnabled(enabled);
    }

    @Override
    public void validate() {
        super.validate();
    }

    /**
     * Returns true if the widget's layout has been {@link #invalidate() invalidated}.
     */
    @Override
    public boolean needsLayout() {
        return super.needsLayout();
    }

    @Override
    public void invalidateHierarchy() {
        super.invalidateHierarchy();
    }

    @Override
    protected void childrenChanged() {
        super.childrenChanged();
    }

    @Override
    protected void sizeChanged() {
        super.sizeChanged();
    }

    @Override
    public void pack() {
        super.pack();
    }

    @Override
    public void setFillParent(boolean fillParent) {
        super.setFillParent(fillParent);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
     * Draws all children. {@link #applyTransform(Batch, Matrix4)} should be called before and {@link #resetTransform(Batch)}
     * after this method if {@link #setTransform(boolean) transform} is true. If {@link #setTransform(boolean) transform} is false
     * these methods don't need to be called, children positions are temporarily offset by the group position when drawn. This
     * method avoids drawing children completely outside the {@link #setCullingArea(Rectangle) culling area}, if set.
     *
     * @param batch
     * @param parentAlpha
     */
    @Override
    protected void drawChildren(Batch batch, float parentAlpha) {
        super.drawChildren(batch, parentAlpha);
    }

    /**
     * Draws all children. {@link #applyTransform(Batch, Matrix4)} should be called before and {@link #resetTransform(Batch)}
     * after this method if {@link #setTransform(boolean) transform} is true. If {@link #setTransform(boolean) transform} is false
     * these methods don't need to be called, children positions are temporarily offset by the group position when drawn. This
     * method avoids drawing children completely outside the {@link #setCullingArea(Rectangle) culling area}, if set.
     *
     * @param shapes
     */
    @Override
    protected void drawDebugChildren(ShapeRenderer shapes) {
        super.drawDebugChildren(shapes);
    }

    /**
     * Returns the transform for this group's coordinate system.
     */
    @Override
    protected Matrix4 computeTransform() {
        return super.computeTransform();
    }

    /**
     * Set the batch's transformation matrix, often with the result of {@link #computeTransform()}. Note this causes the batch to
     * be flushed. {@link #resetTransform(Batch)} will restore the transform to what it was before this call.
     *
     * @param batch
     * @param transform
     */
    @Override
    protected void applyTransform(Batch batch, Matrix4 transform) {
        super.applyTransform(batch, transform);
    }

    /**
     * Restores the batch transform to what it was before {@link #applyTransform(Batch, Matrix4)}. Note this causes the batch to
     * be flushed.
     *
     * @param batch
     */
    @Override
    protected void resetTransform(Batch batch) {
        super.resetTransform(batch);
    }

    /**
     * Set the shape renderer transformation matrix, often with the result of {@link #computeTransform()}. Note this causes the
     * shape renderer to be flushed. {@link #resetTransform(ShapeRenderer)} will restore the transform to what it was before this
     * call.
     *
     * @param shapes
     * @param transform
     */
    @Override
    protected void applyTransform(ShapeRenderer shapes, Matrix4 transform) {
        super.applyTransform(shapes, transform);
    }

    /**
     * Restores the shape renderer transform to what it was before {@link #applyTransform(Batch, Matrix4)}. Note this causes the
     * shape renderer to be flushed.
     *
     * @param shapes
     */
    @Override
    protected void resetTransform(ShapeRenderer shapes) {
        super.resetTransform(shapes);
    }

    /**
     * Children completely outside of this rectangle will not be drawn. This is only valid for use with unrotated and unscaled
     * actors.
     *
     * @param cullingArea May be null.
     */
    @Override
    public void setCullingArea(Rectangle cullingArea) {
        super.setCullingArea(cullingArea);
    }

    /**
     * @return May be null.
     * @see #setCullingArea(Rectangle)
     */
    @Override
    public Rectangle getCullingArea() {
        return super.getCullingArea();
    }

    /**
     * Adds an actor as a child of this group, removing it from its previous parent. If the actor is already a child of this
     * group, no changes are made.
     *
     * @param actor
     */
    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);
    }

    /**
     * Adds an actor as a child of this group at a specific index, removing it from its previous parent. If the actor is already a
     * child of this group, no changes are made.
     *
     * @param index May be greater than the number of children.
     * @param actor
     */
    @Override
    public void addActorAt(int index, Actor actor) {
        super.addActorAt(index, actor);
    }

    /**
     * Adds an actor as a child of this group immediately before another child actor, removing it from its previous parent. If the
     * actor is already a child of this group, no changes are made.
     *
     * @param actorBefore
     * @param actor
     */
    @Override
    public void addActorBefore(Actor actorBefore, Actor actor) {
        super.addActorBefore(actorBefore, actor);
    }

    /**
     * Adds an actor as a child of this group immediately after another child actor, removing it from its previous parent. If the
     * actor is already a child of this group, no changes are made.
     *
     * @param actorAfter
     * @param actor
     */
    @Override
    public void addActorAfter(Actor actorAfter, Actor actor) {
        super.addActorAfter(actorAfter, actor);
    }

    /**
     * Removes all children, actions, and listeners from this group.
     */
    @Override
    public void clear() {
        super.clear();
    }

    /**
     * Returns the first actor found with the specified name. Note this recursively compares the name of every actor in the
     * group.
     *
     * @param name
     */
    @Override
    public <T extends Actor> T findActor(String name) {
        return super.findActor(name);
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
    }

    /**
     * Swaps two actors by index. Returns false if the swap did not occur because the indexes were out of bounds.
     *
     * @param first
     * @param second
     */
    @Override
    public boolean swapActor(int first, int second) {
        return super.swapActor(first, second);
    }

    /**
     * Swaps two actors. Returns false if the swap did not occur because the actors are not children of this group.
     *
     * @param first
     * @param second
     */
    @Override
    public boolean swapActor(Actor first, Actor second) {
        return super.swapActor(first, second);
    }

    /**
     * Returns an ordered list of child actors in this group.
     */
    @Override
    public SnapshotArray<Actor> getChildren() {
        return super.getChildren();
    }

    @Override
    public boolean hasChildren() {
        return super.hasChildren();
    }

    /**
     * When true (the default), the Batch is transformed so children are drawn in their parent's coordinate system. This has a
     * performance impact because {@link Batch#flush()} must be done before and after the transform. If the actors in a group are
     * not rotated or scaled, then the transform for the group can be set to false. In this case, each child's position will be
     * offset by the group's position for drawing, causing the children to appear in the correct location even though the Batch has
     * not been transformed.
     *
     * @param transform
     */
    @Override
    public void setTransform(boolean transform) {
        super.setTransform(transform);
    }

    @Override
    public boolean isTransform() {
        return super.isTransform();
    }

    /**
     * Converts coordinates for this group to those of a descendant actor. The descendant does not need to be a direct child.
     *
     * @param descendant
     * @param localCoords
     * @throws IllegalArgumentException if the specified actor is not a descendant of this group.
     */
    @Override
    public Vector2 localToDescendantCoordinates(Actor descendant, Vector2 localCoords) {
        return super.localToDescendantCoordinates(descendant, localCoords);
    }

    /**
     * If true, {@link #drawDebug(ShapeRenderer)} will be called for this group and, optionally, all children recursively.
     *
     * @param enabled
     * @param recursively
     */
    @Override
    public void setDebug(boolean enabled, boolean recursively) {
        super.setDebug(enabled, recursively);
    }

    /**
     * Returns a description of the actor hierarchy, recursively.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Sets this actor as the event {@link Event#setTarget(Actor) target} and propagates the event to this actor and ancestor
     * actors as necessary. If this actor is not in the stage, the stage must be set before calling this method.
     * <p>
     * Events are fired in 2 phases:
     * <ol>
     * <li>The first phase (the "capture" phase) notifies listeners on each actor starting at the root and propagating downward to
     * (and including) this actor.</li>
     * <li>The second phase notifies listeners on each actor starting at this actor and, if {@link Event#getBubbles()} is true,
     * propagating upward to the root.</li>
     * </ol>
     * If the event is {@link Event#stop() stopped} at any time, it will not propagate to the next actor.
     *
     * @param event
     * @return true if the event was {@link Event#cancel() cancelled}.
     */
    @Override
    public boolean fire(Event event) {
        return super.fire(event);
    }

    /**
     * Notifies this actor's listeners of the event. The event is not propagated to any parents. Before notifying the listeners,
     * this actor is set as the {@link Event#getListenerActor() listener actor}. The event {@link Event#setTarget(Actor) target}
     * must be set before calling this method. If this actor is not in the stage, the stage must be set before calling this method.
     *
     * @param event
     * @param capture If true, the capture listeners will be notified instead of the regular listeners.
     * @return true of the event was {@link Event#cancel() cancelled}.
     */
    @Override
    public boolean notify(Event event, boolean capture) {
        return super.notify(event, capture);
    }

    /**
     * Removes this actor from its parent, if it has a parent.
     *
     * @see Group#removeActor(Actor)
     */
    @Override
    public boolean remove() {
        return super.remove();
    }

    /**
     * Add a listener to receive events that {@link #hit(float, float, boolean) hit} this actor. See {@link #fire(Event)}.
     *
     * @param listener
     * @see InputListener
     * @see ClickListener
     */
    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(listener);
    }

    @Override
    public boolean removeListener(EventListener listener) {
        return super.removeListener(listener);
    }

    @Override
    public DelayedRemovalArray<EventListener> getListeners() {
        return super.getListeners();
    }

    /**
     * Adds a listener that is only notified during the capture phase.
     *
     * @param listener
     * @see #fire(Event)
     */
    @Override
    public boolean addCaptureListener(EventListener listener) {
        return super.addCaptureListener(listener);
    }

    @Override
    public boolean removeCaptureListener(EventListener listener) {
        return super.removeCaptureListener(listener);
    }

    @Override
    public DelayedRemovalArray<EventListener> getCaptureListeners() {
        return super.getCaptureListeners();
    }

    @Override
    public void addAction(Action action) {
        super.addAction(action);
    }

    @Override
    public void removeAction(Action action) {
        super.removeAction(action);
    }

    @Override
    public Array<Action> getActions() {
        return super.getActions();
    }

    /**
     * Returns true if the actor has one or more actions.
     */
    @Override
    public boolean hasActions() {
        return super.hasActions();
    }

    /**
     * Removes all actions on this actor.
     */
    @Override
    public void clearActions() {
        super.clearActions();
    }

    /**
     * Removes all listeners on this actor.
     */
    @Override
    public void clearListeners() {
        super.clearListeners();
    }

    /**
     * Returns the stage that this actor is currently in, or null if not in a stage.
     */
    @Override
    public Stage getStage() {
        return super.getStage();
    }

    /**
     * Returns true if this actor is the same as or is the descendant of the specified actor.
     *
     * @param actor
     */
    @Override
    public boolean isDescendantOf(Actor actor) {
        return super.isDescendantOf(actor);
    }

    /**
     * Returns true if this actor is the same as or is the ascendant of the specified actor.
     *
     * @param actor
     */
    @Override
    public boolean isAscendantOf(Actor actor) {
        return super.isAscendantOf(actor);
    }

    /**
     * Returns this actor or the first ascendant of this actor that is assignable with the specified type, or null if none were
     * found.
     *
     * @param type
     */
    @Override
    public <T extends Actor> T firstAscendant(Class<T> type) {
        return super.firstAscendant(type);
    }

    /**
     * Returns true if the actor's parent is not null.
     */
    @Override
    public boolean hasParent() {
        return super.hasParent();
    }

    /**
     * Returns the parent actor, or null if not in a group.
     */
    @Override
    public Group getParent() {
        return super.getParent();
    }

    /**
     * Called by the framework when an actor is added to or removed from a group.
     *
     * @param parent May be null if the actor has been removed from the parent.
     */
    @Override
    protected void setParent(Group parent) {
        super.setParent(parent);
    }

    /**
     * Returns true if input events are processed by this actor.
     */
    @Override
    public boolean isTouchable() {
        return super.isTouchable();
    }

    @Override
    public Touchable getTouchable() {
        return super.getTouchable();
    }

    /**
     * Determines how touch events are distributed to this actor. Default is {@link Touchable#enabled}.
     *
     * @param touchable
     */
    @Override
    public void setTouchable(Touchable touchable) {
        super.setTouchable(touchable);
    }

    @Override
    public boolean isVisible() {
        return super.isVisible();
    }

    /**
     * If false, the actor will not be drawn and will not receive touch events. Default is true.
     *
     * @param visible
     */
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }

    /**
     * Returns true if this actor and all ancestors are visible.
     */
    @Override
    public boolean ancestorsVisible() {
        return super.ancestorsVisible();
    }

    /**
     * Returns an application specific object for convenience, or null.
     */
    @Override
    public Object getUserObject() {
        return super.getUserObject();
    }

    /**
     * Sets an application specific object for convenience.
     *
     * @param userObject
     */
    @Override
    public void setUserObject(Object userObject) {
        super.setUserObject(userObject);
    }

    /**
     * Returns the X position of the actor's left edge.
     */
    @Override
    public float getX() {
        return super.getX();
    }

    /**
     * Returns the X position of the specified {@link Align alignment}.
     *
     * @param alignment
     */
    @Override
    public float getX(int alignment) {
        return super.getX(alignment);
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    /**
     * Sets the x position using the specified {@link Align alignment}. Note this may set the position to non-integer
     * coordinates.
     *
     * @param x
     * @param alignment
     */
    @Override
    public void setX(float x, int alignment) {
        super.setX(x, alignment);
    }

    /**
     * Returns the Y position of the actor's bottom edge.
     */
    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    /**
     * Sets the y position using the specified {@link Align alignment}. Note this may set the position to non-integer
     * coordinates.
     *
     * @param y
     * @param alignment
     */
    @Override
    public void setY(float y, int alignment) {
        super.setY(y, alignment);
    }

    /**
     * Returns the Y position of the specified {@link Align alignment}.
     *
     * @param alignment
     */
    @Override
    public float getY(int alignment) {
        return super.getY(alignment);
    }

    /**
     * Sets the position of the actor's bottom left corner.
     *
     * @param x
     * @param y
     */
    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }

    /**
     * Sets the position using the specified {@link Align alignment}. Note this may set the position to non-integer
     * coordinates.
     *
     * @param x
     * @param y
     * @param alignment
     */
    @Override
    public void setPosition(float x, float y, int alignment) {
        super.setPosition(x, y, alignment);
    }

    /**
     * Add x and y to current position
     *
     * @param x
     * @param y
     */
    @Override
    public void moveBy(float x, float y) {
        super.moveBy(x, y);
    }

    @Override
    public float getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(float width) {
        super.setWidth(width);
    }

    @Override
    public float getHeight() {
        return super.getHeight();
    }

    @Override
    public void setHeight(float height) {
        super.setHeight(height);
    }

    /**
     * Returns y plus height.
     */
    @Override
    public float getTop() {
        return super.getTop();
    }

    /**
     * Returns x plus width.
     */
    @Override
    public float getRight() {
        return super.getRight();
    }

    /**
     * Called when the actor's position has been changed.
     */
    @Override
    protected void positionChanged() {
        super.positionChanged();
    }

    /**
     * Called when the actor's rotation has been changed.
     */
    @Override
    protected void rotationChanged() {
        super.rotationChanged();
    }

    /**
     * Sets the width and height.
     *
     * @param width
     * @param height
     */
    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
    }

    /**
     * Adds the specified size to the current size.
     *
     * @param size
     */
    @Override
    public void sizeBy(float size) {
        super.sizeBy(size);
    }

    /**
     * Adds the specified size to the current size.
     *
     * @param width
     * @param height
     */
    @Override
    public void sizeBy(float width, float height) {
        super.sizeBy(width, height);
    }

    /**
     * Set bounds the x, y, width, and height.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     */
    @Override
    public void setBounds(float x, float y, float width, float height) {
        super.setBounds(x, y, width, height);
    }

    @Override
    public float getOriginX() {
        return super.getOriginX();
    }

    @Override
    public void setOriginX(float originX) {
        super.setOriginX(originX);
    }

    @Override
    public float getOriginY() {
        return super.getOriginY();
    }

    @Override
    public void setOriginY(float originY) {
        super.setOriginY(originY);
    }

    /**
     * Sets the origin position which is relative to the actor's bottom left corner.
     *
     * @param originX
     * @param originY
     */
    @Override
    public void setOrigin(float originX, float originY) {
        super.setOrigin(originX, originY);
    }

    /**
     * Sets the origin position to the specified {@link Align alignment}.
     *
     * @param alignment
     */
    @Override
    public void setOrigin(int alignment) {
        super.setOrigin(alignment);
    }

    @Override
    public float getScaleX() {
        return super.getScaleX();
    }

    @Override
    public void setScaleX(float scaleX) {
        super.setScaleX(scaleX);
    }

    @Override
    public float getScaleY() {
        return super.getScaleY();
    }

    @Override
    public void setScaleY(float scaleY) {
        super.setScaleY(scaleY);
    }

    /**
     * Sets the scale for both X and Y
     *
     * @param scaleXY
     */
    @Override
    public void setScale(float scaleXY) {
        super.setScale(scaleXY);
    }

    /**
     * Sets the scale X and scale Y.
     *
     * @param scaleX
     * @param scaleY
     */
    @Override
    public void setScale(float scaleX, float scaleY) {
        super.setScale(scaleX, scaleY);
    }

    /**
     * Adds the specified scale to the current scale.
     *
     * @param scale
     */
    @Override
    public void scaleBy(float scale) {
        super.scaleBy(scale);
    }

    /**
     * Adds the specified scale to the current scale.
     *
     * @param scaleX
     * @param scaleY
     */
    @Override
    public void scaleBy(float scaleX, float scaleY) {
        super.scaleBy(scaleX, scaleY);
    }

    @Override
    public float getRotation() {
        return super.getRotation();
    }

    @Override
    public void setRotation(float degrees) {
        super.setRotation(degrees);
    }

    /**
     * Adds the specified rotation to the current rotation.
     *
     * @param amountInDegrees
     */
    @Override
    public void rotateBy(float amountInDegrees) {
        super.rotateBy(amountInDegrees);
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    @Override
    public void setColor(float r, float g, float b, float a) {
        super.setColor(r, g, b, a);
    }

    /**
     * Returns the color the actor will be tinted when drawn. The returned instance can be modified to change the color.
     */
    @Override
    public Color getColor() {
        return super.getColor();
    }

    /**
     * @return May be null.
     * @see #setName(String)
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * Set the actor's name, which is used for identification convenience and by {@link #toString()}.
     *
     * @param name May be null.
     * @see Group#findActor(String)
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * Changes the z-order for this actor so it is in front of all siblings.
     */
    @Override
    public void toFront() {
        super.toFront();
    }

    /**
     * Changes the z-order for this actor so it is in back of all siblings.
     */
    @Override
    public void toBack() {
        super.toBack();
    }

    /**
     * Sets the z-index of this actor. The z-index is the index into the parent's {@link Group#getChildren() children}, where a
     * lower index is below a higher index. Setting a z-index higher than the number of children will move the child to the front.
     * Setting a z-index less than zero is invalid.
     *
     * @param index
     * @return true if the z-index changed.
     */
    @Override
    public boolean setZIndex(int index) {
        return super.setZIndex(index);
    }

    /**
     * Returns the z-index of this actor.
     *
     * @see #setZIndex(int)
     */
    @Override
    public int getZIndex() {
        return super.getZIndex();
    }

    /**
     * Calls {@link #clipBegin(float, float, float, float)} to clip this actor's bounds.
     */
    @Override
    public boolean clipBegin() {
        return super.clipBegin();
    }

    /**
     * Clips the specified screen aligned rectangle, specified relative to the transform matrix of the stage's Batch. The
     * transform matrix and the stage's camera must not have rotational components. Calling this method must be followed by a call
     * to {@link #clipEnd()} if true is returned.
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @return false if the clipping area is zero and no drawing should occur.
     * @see ScissorStack
     */
    @Override
    public boolean clipBegin(float x, float y, float width, float height) {
        return super.clipBegin(x, y, width, height);
    }

    /**
     * Ends clipping begun by {@link #clipBegin(float, float, float, float)}.
     */
    @Override
    public void clipEnd() {
        super.clipEnd();
    }

    /**
     * Transforms the specified point in screen coordinates to the actor's local coordinate system.
     *
     * @param screenCoords
     * @see Stage#screenToStageCoordinates(Vector2)
     */
    @Override
    public Vector2 screenToLocalCoordinates(Vector2 screenCoords) {
        return super.screenToLocalCoordinates(screenCoords);
    }

    /**
     * Transforms the specified point in the stage's coordinates to the actor's local coordinate system.
     *
     * @param stageCoords
     */
    @Override
    public Vector2 stageToLocalCoordinates(Vector2 stageCoords) {
        return super.stageToLocalCoordinates(stageCoords);
    }

    /**
     * Converts the coordinates given in the parent's coordinate system to this actor's coordinate system.
     *
     * @param parentCoords
     */
    @Override
    public Vector2 parentToLocalCoordinates(Vector2 parentCoords) {
        return super.parentToLocalCoordinates(parentCoords);
    }

    /**
     * Transforms the specified point in the actor's coordinates to be in screen coordinates.
     *
     * @param localCoords
     * @see Stage#stageToScreenCoordinates(Vector2)
     */
    @Override
    public Vector2 localToScreenCoordinates(Vector2 localCoords) {
        return super.localToScreenCoordinates(localCoords);
    }

    /**
     * Transforms the specified point in the actor's coordinates to be in the stage's coordinates.
     *
     * @param localCoords
     */
    @Override
    public Vector2 localToStageCoordinates(Vector2 localCoords) {
        return super.localToStageCoordinates(localCoords);
    }

    /**
     * Transforms the specified point in the actor's coordinates to be in the parent's coordinates.
     *
     * @param localCoords
     */
    @Override
    public Vector2 localToParentCoordinates(Vector2 localCoords) {
        return super.localToParentCoordinates(localCoords);
    }

    /**
     * Converts coordinates for this actor to those of a parent actor. The ascendant does not need to be a direct parent.
     *
     * @param ascendant
     * @param localCoords
     */
    @Override
    public Vector2 localToAscendantCoordinates(Actor ascendant, Vector2 localCoords) {
        return super.localToAscendantCoordinates(ascendant, localCoords);
    }

    /**
     * Converts coordinates for this actor to those of another actor, which can be anywhere in the stage.
     *
     * @param actor
     * @param localCoords
     */
    @Override
    public Vector2 localToActorCoordinates(Actor actor, Vector2 localCoords) {
        return super.localToActorCoordinates(actor, localCoords);
    }

    @Override
    public boolean getDebug() {
        return super.getDebug();
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
