package lu.kolja.expandedgt.common.machines.input

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank
import com.gregtechceu.gtceu.integration.ae2.machine.MEInputHatchPartMachine
import com.gregtechceu.gtceu.integration.ae2.slot.ExportOnlyAEFluidList
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder

open class ExpMEInputHatchPartMachine(holder: IMachineBlockEntity, vararg args: Any): MEInputHatchPartMachine(holder, args) {
    open val managedFieldHolder = ManagedFieldHolder(ExpMEInputHatchPartMachine::class.java, MANAGED_FIELD_HOLDER)

    companion object {
        const val SIZE = 32
    }

    override fun getFieldHolder() = managedFieldHolder

    override fun createTank(initialCapacity: Int, slots: Int, vararg args: Any): NotifiableFluidTank {
        this.aeFluidHandler = ExportOnlyAEFluidList(this, SIZE)
        return this.aeFluidHandler
    }
}