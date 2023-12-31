package com.example.fbw_tanks_guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fbw_tanks_guide.Tank;
import com.example.fbw_tanks_guide.TankAdapter;
import com.example.fbw_tanks_guide.TanksDatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private TankAdapter tanksAdapter;
    private List<Tank> tankList;
    private TanksDatabaseHelper databaseHelper;
    private List<Integer> typeImageList;
    private List<Integer> tankImageList;
    private List<Integer> nationImageList;
    private FloatingActionButton button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        recyclerView = findViewById(R.id.recyclerview);
        button = findViewById(R.id.backButton2);
        button.setOnClickListener(this);

        databaseHelper = new TanksDatabaseHelper(this);
        tankList = databaseHelper.getAllTanks();
        tankImageList = Arrays.asList(R.drawable.tank1,R.drawable.tank2,R.drawable.tank3,R.drawable.tank4,R.drawable.tank5,R.drawable.tank6,R.drawable.tank7,R.drawable.tank8,R.drawable.tank9,R.drawable.tank10,R.drawable.tank11,R.drawable.tank12,R.drawable.tank13,R.drawable.tank14,R.drawable.tank15,R.drawable.tank16,R.drawable.tank17,R.drawable.tank18,R.drawable.tank19,R.drawable.tank20,R.drawable.tank21,R.drawable.tank22,R.drawable.tank23);
        typeImageList = Arrays.asList(R.drawable.light_tank_image, R.drawable.medium_tank_image, R.drawable.heavy_tank_image, R.drawable.tankdestroyer_tank_image, R.drawable.notfound_tank_image);
        nationImageList = Arrays.asList(R.drawable.china,R.drawable.soviet_union,R.drawable.united_kingdom,R.drawable.united_states,R.drawable.third_reich_germany,R.drawable.romania);

        tanksAdapter = new TankAdapter(tankList, tankImageList, typeImageList, nationImageList);
        tanksAdapter.updateTankList(tankList);
        recyclerView.setAdapter(tanksAdapter);
// Создайте экземпляр вашего адаптера и других переменных

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tanksAdapter.setItemCount(23);
        tankList = databaseHelper.getAllTanks();
        tanksAdapter.updateTankList(tankList);

        // Создаем несколько объектов Tank с данными
        Tank tank1 = new Tank(1, "E 25", 7, 850, 135, 150, "Немецкая премиумная ПТ-САУ 7 уровня. Отличается огромным ДПМ, отличной маскировкой и посредственной выживаемостью.", "Разработка E 25 велась в рамках программы «E» под управлением Waffenprüfamt 6. Над E 25 работали специалисты компании Argus (г. Карлсруэ) под руководством доктора Хермана Клауэ. Прототип изготовлен не был.", "Германия", "ПТ-САУ");
        Tank tank2 = new Tank(2, "Kanonenjagdpanzer 105", 8, 1050, 390, 268, "Немецкая премиумная ПТ-САУ 8 уровня. Хороша своей мобильностью и маскировкой. Фактической брони здесь нет, поэтому ей присущ только кустовой геймплей.", "Первые прототипы Kanonenjagdpanzer были построены в 1960 году компаниями Hanomag и Henschel для ФРГ, а серийный выпуск продолжался вплоть до 1967 года. Всего для Бундесвера было построено 770 единиц, а для вооружённых сил Бельгии — 80. Начиная с 1983 года эта самоходка перестала отвечать требованиям современной войны. По утверждению производителя, их можно было перевооружить 105-мм пушками, но часть машин переоборудовали в наблюдательные, а часть — в противотанковые ракетные установки. В территориальных войсках Kanonenjagdpanzer (известные так же как Jagdpanzer Kanone 90mm) стояли на вооружении до 1990 года.", "Германия", "ПТ-САУ");
        Tank tank3 = new Tank(3,"Abrams Китайский", 10, 0,0,0,"Большинство характеристик неизвестно.", "Был подарен армии БТ-5 наряду с T-54 Малым. Утерян в 2022 году.", "Китай", "Утерянный танк");
        Tank tank4 = new Tank(4, "ИС-1", 7, 1230, 390, 175, "Советский ТТ-7, обладает хорошей бронёй и достаточно мощным орудием.", "Тяжёлый танк ИС-1 (ИC-85) стал результатом глубокой модернизации танка КВ-1. Основным вооружением танка являлась пушка Д-5Т калибра 85 мм. Серийное производство машины началось в октябре 1943 года, но уже в начале 1944 года было прекращено в связи с началом выпуска в декабре 1943 года танка ИС-2 (ИС-122). Всего было выпущено 107 машин.", "СССР", "Тяжёлый танк");
        Tank tank5 = new Tank(5, "Pz.38t", 3, 445, 60, 62, "Коллекционный немецкий танк 3 уровня. В модификации Project имеет мощную фугасную пушку.", "Разработан компанией ČKD для нужд Чехословацкой армии в 1938 году. Во время немецкой оккупации состоял на вооружении Вермахта. В составе немецких танковых частей применялся в польской и французской кампаниях, а также на советско-германском фронте. В боевых частях первой линии использовался до середины 1942 года. Было выпущено примерно 1400 танков в восьми вариантах (Ausf A/B/C/D/E/F/S/G).", "Германия", "Лёгкий танк");
        Tank tank6 = new Tank(6, "Pz.Kpfw.II", 2, 340, 33, 39, "Немецкий ЛТ 2 уровня. В реальной комплектации имеет барабан на 3 снаряда, но по соображениям играбельности в войсках FBW имеет цикличное орудие.", "Последняя модификация лёгкого танка серии Pz. II. Основное отличие от предыдущих вариантов — усиленное бронирование, орудие 2 cm KwK 38 и улучшенные смотровые приборы. В период с марта 1941 по декабрь 1942 года было выпущено 524 машины.", "Германия", "Лёгкий танк");
        Tank tank7 = new Tank(7, "StuG III Ausf. B", 4, 400, 350, 70, "Немецкая штатная ПТ-САУ 4 уровня. Обладает высоким уроном, но плохой бронепробиваемостью.", "В 1935 Эрих фон Манштейн в письме к генералу Беку описал идею машин штурмовой артиллерии, главной задачей которых должна была быть непосредственная поддержка атакующих подразделений пехоты. В 1937 году были изготовлены первые пять прототипов так называемой «нулевой» серии. Ранние модификации от Ausf.A до Ausf.F/8 выпускались до декабря 1942 года.", "Германия", "ПТ-САУ");
        Tank tank8 = new Tank(8, "Pz.IV Ausf. D", 4, 540, 110,103, "Немецкий коллекционный СТ 4 уровня.", "Выпуск этой модификации танка Pz. IV начался в октябре 1939 года. Основными отличиями стали усиленное бронирование и наружное расположение маски пушки. За время серийного выпуска, который продолжался до мая 1940 года, было выпущено 229 машин этого типа.", "Германия", "Средний танк");
        Tank tank9 = new Tank(9, "Sturmpanzer VI Sturmtiger", 10, 2100, 1950, 250, "Немецкая экспериментальная САУ 10 уровня. Играть на ней можно было только в режимах, в данный момент небоеспособна.", "Sturmpanzer VI Sturmtiger — реально существовавшее штурмовое орудие, выпущенное в ограниченном количестве. Его лобовая деталь рубки толщиной 150 мм, расположенная под углом 47° к вертикали, была практически непробиваема для большинства танковых и противотанковых орудий времён Второй мировой. Вооружение в виде 380-мм реактивного бомбомёта обеспечило «Штурмтигру» непревзойдённую в своём классе огневую мощь, сравнимую разве что с железнодорожными или наиболее тяжёлыми традиционными артиллерийскими системами.", "Германия", "ПТ-САУ");
        Tank tank10 = new Tank(10, "Т-54 (Type 59)", 8, 1300, 250, 185, "Советско-Китайский премиумный СТ 8 уровня. Отличается хорошим орудием и монолитной бронёй во лбу.", "Китайский средний танк. Изначально являлся копией советского среднего танка Т-54А. Принят на вооружение в 1959 году. У первых выпущенных танков отсутствовали стабилизатор вооружения и прибор ночного видения. В дальнейшем танк постоянно модернизировался. Всего с 1958 по 1987 год выпущено, по разным сведениям, от 6000 до 9500 машин всех модификаций.", "СССР/Китай", "Средний танк");
        Tank tank11 = new Tank(11, "Т-34/76",5, 590, 115, 125, "Советский СТ 5 уровня. Славен своей малой башней и успешным применением во время ВОВ.", "Легенда советских бронетанковых войск. Самый массовый советский танк Второй мировой войны. С 1940 по 1944 год на различных заводах СССР было изготовлено 33805 машин трёх модификаций.", "СССР", "Средний танк");
        Tank tank12 = new Tank(12, "Т-60", 2, 340, 40, 58, "Советский ЛТ 2 уровня. В войсках FBW выполняет задачи диверсанта-разведчика.", "Разработан в августе 1941 года КБ завода №37 под руководством Н.А. Астрова. В сентябре того же года был принят на вооружение. За время серийного выпуска построено 5920 танков. Серийное производство продолжалось до февраля 1943 года, однако танк состоял на вооружении до конца войны.", "СССР", "Лёгкий танк");
        Tank tank13 = new Tank(13, "Т-34/76 (обр. 1940 г.)", 5, 560, 85, 112, "Коллекционная версия своего собрата по уровню. Обладает уменьшеными характеристиками, но повышенным коэффицентом фарма.", "См. Историю танка Т-34/76", "СССР", "Средний танк");
        Tank tank14 = new Tank(14, "БТ-5", 3, 410, 47, 55, "Советский ЛТ 3 уровня. Выделяется на фоне остальных огромной скоростью.", "Серийный танк семейства БТ. Является усовершенствованным вариантом танка БТ-2 в направлении усиления пушечного вооружения и двигателя советского производства при незначительном увеличении высоты и массы машины. БТ-5 являлся одним из основных танков РККА довоенного периода. Танки данной модификации принимали участие в гражданской войне в Испании, боях на Халхин-Голе, походе в Польшу, Советско-финской и Великой Отечественной войнах. Всего было выпущено 1884 машины.", "СССР", "Лёгкий танк");
        Tank tank15 = new Tank(15, "StuG IV", 5, 470, 125, 110, "Немецкая премиум-ПТ 5 уровня. В модификации от Project имеет барабанное орудие на 3 снаряда.", "По предложению Министерства вооружений в феврале 1943 года компания Krupp начала испытания установки рубки доработанной StuG III на новое шасси Pz.Kpfw. IV Ausf. H и J. Первые машины сошли с конвейера к декабрю 1943 года, а с января 1944 компания Krupp полностью перешла на их производство, свернув выпуск Pz. IV. Всего произведено 1108 машин и ещё 31 переделана из танков.", "Германия", "ПТ-САУ");
        Tank tank16 = new Tank(16, "СУ-76И", 3, 285, 110, 86, "Советская премиум-ПТ 3 уровня.", "Первый опытный образец СУ-76И (И — «иностранная») удалось собрать к началу марта 1943 года на базе трофейных шасси танков StuG III и Pz.Kpfw. III с использованием советской 76-мм пушки Ф-34. Всего было выпущено 200 машин. В боевых действиях СУ-76И использовались до конца лета 1944 года, а в учебных частях — до конца войны. Дальнейшим этапом развития должна была стать СУ-85И.", "СССР", "ПТ-САУ");
        Tank tank17 = new Tank(17, "СТ-II", 10, 2500, 440, 258, "Советский ТТ 10 уровня. Обладает уникальным спаренным орудием." + "\n" + "ПРИМЕЧАНИЕ: Урон указан за 1 выстрел, за залп урон суммируется.", "Проект тяжёлого танка со спаренной орудийной установкой, являющийся развитием проекта тяжёлого танка СТ-I. При сохранении габаритов и массы предполагалось вооружить его двумя орудиями калибра 100 или 122 мм. Существовал только в эскизных чертежах.", "СССР", "Тяжёлый танк");
        Tank tank18 = new Tank(18, "Cromwell", 6, 840, 135, 145, "Средний танк Великобритании, 6 уровень. Хорош своим ДПМом, но плох посредственным бронированием.", "Разработан в 1941–1942 годах компанией BRC&W. Выпускался серийно с осени 1943 по 1945 год. Всего было выпущено 1070 танков всех модификаций. Активно использовался британскими войсками в северо-западной Европе в 1944–1945 годах.", "Великобритания", "Средний танк");
        Tank tank19 = new Tank(19, "СУ-100", 6, 650, 250,175, "Советская ПТ-САУ 6 уровня. Легенда в рядах FBW.", "ПТ-САУ на базе Т-34-85 и СУ-85. Всего с сентября 1944 по июнь 1945 было выпущено 2495 машин. С принятием на вооружение данной самоходки РККА получила высокоэффективное противотанковое средство с исключительно мощным вооружением, способное противостоять любым образцам немецкой бронетехники.", "СССР", "ПТ-САУ");
        Tank tank20 = new Tank(20, "ИСУ-152", 8, 1200, 750, 260, "Легендарная Советская ПТ-САУ 8 уровня. Хороша своим разовым уроном, но плоха долгим КД.", "Разработана на базе танка ИС. Создавалась для замены СУ-152 в связи с прекращением производства КВ-1с. С ноября 1943 по июнь 1945 года было изготовлено 4635 машин.", "СССР", "ПТ-САУ");
        Tank tank21 = new Tank(21, "Т-34/85", 6, 810, 180, 144, "Советский СТ-6. Один из танков Победы.", "Является завершающей модификацией танка Т-34 образца 1943 г. Новая трёхместная орудийная башня позволила установить более мощную 85-мм пушку. Это значительно повысило боевую эффективность танка по сравнению с предшественником Т-34-76. Всего было выпущено более 35 тысяч единиц различных модификаций. До настоящего времени состоит на вооружении ряда стран.", "СССР", "Средний танк");
        Tank tank22 = new Tank(22, "T110E5", 10, 2200, 400, 258, "Тяжёлый монолитный танк 10 уровня США. Обладает отличным ДПМом и бронёй.", "Разрабатывался с 1952 года как тяжёлый танк с более мощным, чем у Т-43 (М103), вооружением. На танк накладывались существенные ограничения по габаритам, так как машина должна была проходить через туннели Бернских Альп. После проработки различных компоновочных решений работы над машиной были свёрнуты. Не было построено ни одного экземпляра.", "США", "Тяжёлый танк");
        Tank tank23 = new Tank(23, "Comet", 7, 1150, 140, 148, "СТ 7 уровня Великобритании. Схож по характеристикам со своим младшим братом Cromwell' ем.", "Британский танк периода Второй мировой войны, принимавший участие в боевых действиях. Дальнейшее развитие крейсерского танка Cromwell. С сентября 1944 года до конца 1945 года было выпущено 1186 машин.", "Великобритания", "Средний танк");

        databaseHelper.addTank(tank1);
        databaseHelper.addTank(tank2);
        databaseHelper.addTank(tank3);
        databaseHelper.addTank(tank4);
        databaseHelper.addTank(tank5);
        databaseHelper.addTank(tank6);
        databaseHelper.addTank(tank7);
        databaseHelper.addTank(tank8);
        databaseHelper.addTank(tank9);
        databaseHelper.addTank(tank10);
        databaseHelper.addTank(tank11);
        databaseHelper.addTank(tank12);
        databaseHelper.addTank(tank13);
        databaseHelper.addTank(tank14);
        databaseHelper.addTank(tank15);
        databaseHelper.addTank(tank16);
        databaseHelper.addTank(tank17);
        databaseHelper.addTank(tank18);
        databaseHelper.addTank(tank19);
        databaseHelper.addTank(tank20);
        databaseHelper.addTank(tank21);
        databaseHelper.addTank(tank22);
        databaseHelper.addTank(tank23);


    }

    @Override
    public void onClick(View v) {
        Intent intentBack = new Intent(getApplicationContext(), HeadActivity.class);
        startActivity(intentBack);
        finish();
    }
}
