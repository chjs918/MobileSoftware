package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<MovieData> movieDataList;
    private LayoutInflater layoutInflater;
    MovieDBHelper movieDBHelper;


    public MovieAdapter(Context context, int layout, ArrayList<MovieData> movieDataList) {
        this.context = context;
        this.layout = layout;
        this.movieDataList = movieDataList;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //원본 데이터의 개수 반환
        return movieDataList.size();
    }

    @Override
    //어떤 객체든지 반환할수있게 최상위 객체로 되어있음
    public Object getItem(int i) {
        //i번째 원본데이터 반환
        return movieDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //i번째 mydata를 꺼내서 그 객체가 갖고있는 _id 게터 호출
        return movieDataList.get(i).get_id();
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup viewGroup) {
        //pos는 순서
        //pos번째 원본데이터꺼내서 레이아웃과 결합 후 화면 만들기
        final int position = pos;
        //스테틱클래스니까 계속 유지된다.
        ViewHolder viewHolder;

        //맨처음 컨버트뷰가 빈화면으로 들어왔을때만 findViewById 실행
        if(convertView == null) {
            //1. 컨버트뷰만들고
            convertView = layoutInflater.inflate(layout, viewGroup, false);
            viewHolder = new ViewHolder();
            //2. 화면에있는항목들을싹찾아서 뷰홀더에 보관하고
            viewHolder.tvTitle = convertView.findViewById(R.id.tvTitle);
            viewHolder.tvYear = convertView.findViewById(R.id.tvYear);
            viewHolder.tvGrade = convertView.findViewById(R.id.tvGrade);
            viewHolder.tvImage = convertView.findViewById(R.id.image);
            //3. setTag로 convertView에 보관한다
            convertView.setTag(viewHolder);
        } else {
            //컨버트뷰가 한번이라도만들어졌으면 뷰홀더가 당연히 있으니까 걍 꺼내쓰면됨
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(movieDataList.get(pos).getTitle());
        viewHolder.tvYear.setText(movieDataList.get(pos).getYear());
        viewHolder.tvGrade.setRating(movieDataList.get(pos).getGrade());
        if(pos == 0) {
            viewHolder.tvImage.setImageResource(R.drawable.frozen);
        } else if(pos == 1) {
            viewHolder.tvImage.setImageResource(R.drawable.sen);
        } else if(pos == 2) {
            viewHolder.tvImage.setImageResource(R.drawable.withgod);
        } else if(pos == 3) {
            viewHolder.tvImage.setImageResource(R.drawable.doduk);
        } else if(pos == 4) {
            viewHolder.tvImage.setImageResource(R.drawable.kingman);
        } else {
            viewHolder.tvImage.setImageResource(R.drawable.busan);
        }
        return convertView;
    }

    static class ViewHolder {
        public ViewHolder(){
            tvTitle = null;
            tvGrade = null;
            tvYear = null;
            tvImage = null;
        }
        TextView tvTitle;
        RatingBar tvGrade;
        TextView tvYear;
        ImageView tvImage;
    }
}
