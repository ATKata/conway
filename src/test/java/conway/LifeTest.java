package conway;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LifeTest {

    @Test
    public void step_nextStepOfEmptyLifeIsEmptyLife() throws Exception {
        Life life = new Life(5,5);
        Life next = life.step();
        assertThat(life).isEqualTo(next);
    }

}