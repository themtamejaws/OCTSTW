import java.util.logging.*;

class BoardGen {
    //from http://stackoverflow.com/questions/8840729/android-hexagon-grid

    protected void onLayout(final boolean changed, final int l, final int t, final int r, final int b) {
            Log.d(TAG, "board.onlayout called with size "+mSize+" l: "+l+" r: "+r+" t: "+t+" b: "+b);

                //If the dimensions of the board haven't changed, a redraw isn't necessary. Just update the images of the views instead by calling invalidate().
                if (!changed && !mSizeInvalidated) {
                    invalidate();
                    return;
                }
                
                int childCount = getChildCount();

    // Generates generic size params for a single hexagon's spacing with radius 1
    float radius = 1;
    float verticalMargin = -radius / 4;
    float horizontalMargin = ((float) Math.sqrt(3) / 2 - 1) * radius;
    float height = 2 * radius;
    float width = height;
    float effectiveHeight = height + 2 * verticalMargin;
    float effectiveWidth = width + 2 * horizontalMargin;    
    
    // Generates total size of board (using GAME_TYPE_HEX orientation)
    float totalHeight = (radius * (3 * mSize + 1)) / 2;
    float totalWidth = (((float) mSize * 3  - 1)/ 2) * ((float) Math.sqrt(3)) * radius;
    
    // Makes LayoutParams for Android (maybe??)
    LayoutParams layoutParams = new LayoutParams((int) width, (int) height);

    //
    float x_offset_row = 0;
    switch (mCenterHorizontal) {
        //the left side of the grid should be at non-negative coordinates.
        case 1: {
                    x_offset_row += Math.max(0,(r-l-totalWidth)/2);
            break;
        }
        case 2: {x_offset_row += Math.max(0,(r-l-totalWidth));
            break;
        }
        case 0:
        default:{ 
            break;
        }
    }

    //calculate the y_offset for vertical centering.
    float y_offset = 0;
    switch (mCenterVertical) {
        case 1: {
                    y_offset = Math.max(0, (b - t - totalHeight) / 2);
                    break;
        }
        case 2: {
                    y_offset = Math.max(0, (b - t -totalHeight));
                    break;
        }
    }

    int cell = 0;
    for (int row = 0; row < mSize; ++row) {
        float x_offset = x_offset_row;
        int rowLength = mSize;

        Log.d(TAG, "Drawing row "+row+" with "+rowLength+" cells.");
        for (int col = 0; col < rowLength; ++col) {
            ImageView v;
            if (cell < childCount) {
                v = (ImageView) getChildAt(cell);
            } else {
            v = new ImageView(super.getContext());
            v.setLayoutParams(layoutParams);
            v.setOnClickListener(onClickListener);
            addViewInLayout(v, cell, v.getLayoutParams(), true);
            }

            //Set the image (color) of the cell and put its index in a tag, so we can retrieve the number of the clicked cell in the onClickListener.
            v.setImageResource(mImageIds[mImages[cell]]);
            v.setTag(cell);

            //Set the bounds of the image, which will automatically be cropped in the available space.
            v.layout((int) x_offset, (int) y_offset, (int) (x_offset + width), (int) (y_offset + height));
            x_offset += effectiveWidth;
            ++cell;
        }
        y_offset += effectiveHeight;
        x_offset_row += effectiveWidth / 2;

    }

    mSizeInvalidated=false;

    }
}
