package provaObserver;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarre implements Grafici {

	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	ChartPanel pan;
	JFreeChart c;
	DataTaker t;

	public GraficoBarre(DataTaker t) {
		this.t = t;
	}

	@Override
	public void update() {
		dataset = new DefaultCategoryDataset();
		dataset.setValue(t.getW(), "win", "");
		dataset.setValue(t.getL(), "lose", "");
		dataset.setValue(t.getD(), "draw", "");
		c = ChartFactory.createBarChart("match statistic", "", "", dataset, PlotOrientation.VERTICAL, true, true, true);
		pan = new ChartPanel(c);
		pan.setBounds(320, 40, 300, 300);
	}

	@Override
	public ChartPanel getChart() {
		return pan;
	}

}
