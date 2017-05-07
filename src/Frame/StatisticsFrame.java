package Frame;

/**
 * Created by gao27024037 on 2017/5/6.
 */
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import static Algorithm.Parameter.*;


public class StatisticsFrame {
    ChartPanel frame1;
    public StatisticsFrame(){
        JFreeChart jfreechart = ChartFactory.createLineChart("遗传算法最小距离进化图", "总代数："+generation, "距离", this.createDataset(),  PlotOrientation.VERTICAL, true, false,false);
        CategoryPlot plot = jfreechart.getCategoryPlot();
        plot.setNoDataMessage("没有数据");
        frame1=new ChartPanel(jfreechart,true);

    }

    public DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset lineDataSet = new DefaultCategoryDataset();
        // 曲线名称
        String series = "最佳距离";  // series指的就是报表里的那条数据线
        String series2 = "次佳距离";  // series指的就是报表里的那条数据线
        String seriesA = "平均距离";  // series指的就是报表里的那条数据线
        //因此 对数据线的相关设置就需要联系到serise
        //比如说setSeriesPaint 设置数据线的颜色
        for (int i = 0; i < generation; i++) {
            lineDataSet.addValue(chartData.get(i),series+"",""+i);
            lineDataSet.addValue(chartData2.get(i),series2+"",""+i);
            lineDataSet.addValue(chartDataAverage.get(i),seriesA+"",""+i);
        }
        return lineDataSet;
    }

    public ChartPanel getChartPanel(){
        return frame1;
    }
}