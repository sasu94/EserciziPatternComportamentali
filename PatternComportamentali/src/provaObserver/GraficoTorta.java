package provaObserver;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoTorta implements Grafici {

	DefaultPieDataset dataset;
	ChartPanel pan;

	DataTaker t;

	public GraficoTorta(DataTaker t) {
		this.t = t;
	}

	@Override
	public ChartPanel getChart() {

		return pan;

	}

	@Override
	public void update() {
		dataset = new DefaultPieDataset();
		dataset.setValue("win", new Integer(t.getW()));
		dataset.setValue("lose", new Integer(t.getL()));
		dataset.setValue("draw", new Integer(t.getD()));
		JFreeChart c = ChartFactory.createPieChart("match statistic", dataset, true, true, true);

		pan = new ChartPanel(c);
		pan.setBounds(10, 40, 300, 300);
	}

}
