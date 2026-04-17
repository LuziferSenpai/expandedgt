package lu.kolja.expandedgt.common.machines.input.stocking

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank
import com.gregtechceu.gtceu.integration.ae2.machine.MEInputHatchPartMachine
import com.gregtechceu.gtceu.integration.ae2.machine.MEStockingHatchPartMachine
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder

class ExpMEStockingHatchPartMachine(holder: IMachineBlockEntity, vararg args: Any): MEStockingHatchPartMachine(holder, args) {
    open val managedFieldHolder = ManagedFieldHolder(MEStockingHatchPartMachine::class.java, MEInputHatchPartMachine.MANAGED_FIELD_HOLDER)

    companion object {
        const val SIZE = 32
    }

    override fun createTank(
        initialCapacity: Int,
        slots: Int,
        vararg args: Any
    ): NotifiableFluidTank {
        this.aeFluidHandler = ExportOnlyAEStockingFluidList(this, SIZE)
        return this.aeFluidHandler
    }

    override fun getFieldHolder() = managedFieldHolder
}