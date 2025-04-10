package agents;

import repast.simphony.context.Context;
import repast.simphony.context.DefaultContext;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.schedule.ISchedule;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.engine.schedule.ScheduledMethod;




public class HousingContextBuilder implements ContextBuilder<Object> {

    @Override
    public Context<Object> build(Context<Object> context) {
        if (context == null) {
            context = new DefaultContext<>();
        }

        context.setId("HousingContext");

        // Beispiel-Agent hinzufügen
        HouseholdAgent agent = new HouseholdAgent(0, 0);
        context.add(agent);

        return context;
    }
}

