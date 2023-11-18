package com.example.fbw_tanks_guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class TankAdapter extends RecyclerView.Adapter<TankAdapter.TankViewHolder> {

    private List<Tank> tankList;
    private HashMap<String, Integer> tankImageMap;

    private int itemCount = 23;

    public void setTankList(List<Tank> tankList) {
        this.tankList = tankList;
        notifyDataSetChanged();
    }

    public TankAdapter(List<Tank> tankList, List<Integer> imageList, List<Integer> tankImageList, List<Integer> typeImageList) {
        this.tankList = tankList;
        setupTankImageMap();
    }

    private void setupTankImageMap() {
        // Добавьте остальные соответствия названий танков и идентификаторов изображений
        tankImageMap = new HashMap<>();
        tankImageMap.put("E 25", R.drawable.tank1);
        tankImageMap.put("Kanonenjagdpanzer 105", R.drawable.tank2);
        tankImageMap.put("Abrams Китайский", R.drawable.tank3);
        tankImageMap.put("ИС-1", R.drawable.tank4);
        tankImageMap.put("Pz.38t", R.drawable.tank5);
        tankImageMap.put("Pz.Kpfw.II", R.drawable.tank6);
        tankImageMap.put("StuG III Ausf. B", R.drawable.tank7);
        tankImageMap.put("Pz.IV Ausf. D", R.drawable.tank8);
        tankImageMap.put("Sturmpanzer VI Sturmtiger", R.drawable.tank9);
        tankImageMap.put("Т-54 (Type 59)", R.drawable.tank10);
        tankImageMap.put("Т-34/76", R.drawable.tank11);
        tankImageMap.put("Т-60", R.drawable.tank12);
        tankImageMap.put("Т-34/76 (обр. 1940 г.)", R.drawable.tank13);
        tankImageMap.put("БТ-5", R.drawable.tank14);
        tankImageMap.put("StuG IV", R.drawable.tank15);
        tankImageMap.put("СУ-76И", R.drawable.tank16);
        tankImageMap.put("СТ-II", R.drawable.tank17);
        tankImageMap.put("Cromwell", R.drawable.tank18);
        tankImageMap.put("СУ-100", R.drawable.tank19);
        tankImageMap.put("ИСУ-152", R.drawable.tank20);
        tankImageMap.put("Т-34/85", R.drawable.tank21);
        tankImageMap.put("T110E5", R.drawable.tank22);
        tankImageMap.put("Comet", R.drawable.tank23);
    }

    @NonNull
    @Override
    public TankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tank, parent, false);
        return new TankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TankViewHolder holder, int position) {
        Tank tank = tankList.get(position);
        holder.nameTextView.setText(tank.getName());
        holder.levelTextView.setText("Уровень: " + tank.getLevel());
        holder.healthTextView.setText("Здоровье: " + tank.getHealth());
        holder.damageTextView.setText("Урон: " + tank.getDamage());
        holder.armorTextView.setText("Бронепробитие: " + tank.getArmor());
        holder.nationTextView.setText("Нация: " + tank.getNation());
        holder.descriptionTextView.setText("Описание: " + tank.getDescription());
        holder.historyTextView.setText("Историческая справка: " + tank.getHistory());

        // Устанавливаем изображения
        int tankImageId = tankImageMap.getOrDefault(tank.getName(), R.drawable.notfound_tank_image);
        int typeImageId = getTypeImageId(tank.getType());
        int nationImageId = getNationImageId(tank.getNation());

        holder.tankImageView.setImageResource(tankImageId);
        holder.typeImageView.setImageResource(typeImageId);
        holder.nationImageView.setImageResource(nationImageId);
    }

    private int getTypeImageId(String type) {
        switch (type) {
            case "Лёгкий танк":
                return R.drawable.light_tank_image;
            case "Средний танк":
                return R.drawable.medium_tank_image;
            case "Тяжёлый танк":
                return R.drawable.heavy_tank_image;
            case "ПТ-САУ":
                return R.drawable.tankdestroyer_tank_image;
            default:
                return R.drawable.notfound_tank_image;
        }
    }

    private int getNationImageId(String nation) {
        switch (nation) {
            case "СССР" :
                return R.drawable.soviet_union;
            case "Великобритания":
                return R.drawable.united_kingdom;
            case "Румыния":
                return R.drawable.romania;
            case "США":
                return R.drawable.united_states;
            case "Германия":
                return R.drawable.third_reich_germany;
            case "Китай":
                return R.drawable.china;
            default:return R.drawable.notfound_tank_image;
        }
    }

    public static class TankViewHolder extends RecyclerView.ViewHolder {
        private ImageView tankImageView;
        private ImageView typeImageView;
        private ImageView nationImageView;
        private TextView nameTextView;
        private TextView levelTextView;
        private TextView healthTextView;
        private TextView damageTextView;
        private TextView armorTextView;
        private TextView descriptionTextView;
        private TextView historyTextView;
        private TextView nationTextView;
        private List<Tank> tankList;

        public TankViewHolder(@NonNull View itemView) {
            super(itemView);
            tankImageView = itemView.findViewById(R.id.tankImageView);
            typeImageView = itemView.findViewById(R.id.typeImageView);
            nationImageView = itemView.findViewById(R.id.nationImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
            healthTextView = itemView.findViewById(R.id.healthTextView);
            damageTextView = itemView.findViewById(R.id.damageTextView);
            armorTextView = itemView.findViewById(R.id.armorTextView);
            nationTextView = itemView.findViewById(R.id.nationTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            historyTextView = itemView.findViewById(R.id.historyTextView);
        }

        }
    public void updateTankList(List<Tank> tankList) {
        this.tankList = tankList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return Math.min(tankList.size(), itemCount);
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
        notifyDataSetChanged();
    }
    }

