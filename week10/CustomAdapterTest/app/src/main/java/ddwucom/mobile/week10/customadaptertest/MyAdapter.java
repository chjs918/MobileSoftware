package ddwucom.mobile.week10.customadaptertest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<MyData> myDataList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, int layout, ArrayList<MyData> myDataList){
        this.context = context;
        this.layout = layout;
        this.myDataList = myDataList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        //원본 데이터의 개수 반환
        return myDataList.size();
    }

    @Override
    //어떤 객체든지 반환할수있게 최상위 객체로 되어있음
    public Object getItem(int i) {
        //i번째 원본데이터 반환
        return myDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        //i번째 mydata를 꺼내서 그 객체가 갖고있는 _id 게터 호출
        return myDataList.get(i).get_id();
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
            viewHolder.textNo = convertView.findViewById(R.id.tvNo);
            viewHolder.textName = convertView.findViewById(R.id.tvName);
            viewHolder.textPhone = convertView.findViewById(R.id.tvPhone);
            viewHolder.btnCheck = convertView.findViewById(R.id.btnCheck);
            //3. setTag로 convertView에 보관한다
            convertView.setTag(viewHolder);
        } else {
            //컨버트뷰가 한번이라도만들어졌으면 뷰홀더가 당연히 있으니까 걍 꺼내쓰면됨
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.btnCheck.setFocusable(false);

        viewHolder.textNo.setText(String.valueOf(myDataList.get(position).get_id()));
        viewHolder.textName.setText(myDataList.get(position).getName());
        viewHolder.textPhone.setText(myDataList.get(position).getPhone());
        viewHolder.btnCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context, myDataList.get(position).getPhone() + " 선택", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    static class ViewHolder {
        TextView textNo;
        TextView textName;
        TextView textPhone;
        Button btnCheck;

    }
}
