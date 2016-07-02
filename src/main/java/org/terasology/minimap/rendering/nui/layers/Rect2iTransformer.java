/*
 * Copyright 2016 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.minimap.rendering.nui.layers;

import org.terasology.math.geom.BaseVector2i;
import org.terasology.math.geom.Rect2i;
import org.terasology.math.geom.Vector2i;

/**
 * TODO Type description
 */
public class Rect2iTransformer {

    private Rect2i source;
    private Rect2i target;

    public Rect2iTransformer(Rect2i source, Rect2i target) {
        this.source = source;
        this.target = target;
    }

    public Vector2i apply(int wx, int wy) {
        return new Vector2i(applyX(wx), applyY(wy));
    }

    public Vector2i apply(BaseVector2i v) {
        return new Vector2i(applyX(v.getX()), applyY(v.getY()));
    }

    public int applyX(int wx) {
        return target.minX() + (wx - source.minX()) * target.width() / source.width();
    }

    public int applyY(int wy) {
        return target.minY() + (wy - source.minY()) * target.height() / source.height();
    }

    public Rect2i getSource() {
        return source;
    }

    public Rect2i getTarget() {
        return target;
    }

    /**
     * @return
     */
    public float getScaleX() {
        return (float)target.width() / source.width();
    }

    /**
     * @return
     */
    public float getScaleY() {
        return (float)target.height() / source.height();
    }
}
