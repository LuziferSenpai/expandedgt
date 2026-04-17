package lu.kolja.expandedgt.common.machines.input

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler
import com.gregtechceu.gtceu.integration.ae2.machine.MEInputBusPartMachine
import com.gregtechceu.gtceu.integration.ae2.slot.ExportOnlyAEItemList
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder

open class ExpMEInputBusPartMachine(holder: IMachineBlockEntity, vararg args: Any) :
    MEInputBusPartMachine(holder, args) {
    open val managedFieldHolder = ManagedFieldHolder(ExpMEInputBusPartMachine::class.java, MANAGED_FIELD_HOLDER)

    companion object {
        const val SIZE = 32
    }

    override fun getFieldHolder() = managedFieldHolder

    override fun createInventory(vararg args: Any?): NotifiableItemStackHandler {
        this.aeItemHandler = ExportOnlyAEItemList(this, SIZE)
        return this.aeItemHandler
    }
}