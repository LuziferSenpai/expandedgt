package lu.kolja.expandedgt.common.machines.input.stocking

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler
import com.gregtechceu.gtceu.integration.ae2.machine.MEInputBusPartMachine
import com.gregtechceu.gtceu.integration.ae2.machine.MEStockingBusPartMachine
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder

open class ExpMEStockingBusPartMachine(holder: IMachineBlockEntity, vararg args: Any) : MEStockingBusPartMachine(holder, args) {
    open val managedFieldHolder = ManagedFieldHolder(MEStockingBusPartMachine::class.java, MEInputBusPartMachine.MANAGED_FIELD_HOLDER)

    companion object {
        const val SIZE = 32
    }

    override fun createInventory(vararg args: Any?): NotifiableItemStackHandler {
        this.aeItemHandler = ExportOnlyAEStockingItemList(this, SIZE)
        return this.aeItemHandler
    }

    override fun getFieldHolder() = managedFieldHolder
}
