class TreeNode<T: Comparable<T>>(
    private val data: T? = null,
    private val left: TreeNode<T>? = null,
    private val right: TreeNode<T>? = null,
) {
    fun add(value: T): TreeNode<T> {
        if (data == null) {
            return TreeNode(value, left, right)
        }

        if (data == value) {
            return TreeNode(value, left, right)
        }

        return if (value < data) {
            TreeNode(data, left?.add(value) ?: TreeNode(value), right)
        } else {
            TreeNode(data, left, right?.add(value) ?: TreeNode(value))
        }
    }

    fun exists(value: T): Boolean {
        if (data == null) {
            return false
        }

        if (data == value) {
            return true
        }

        return if (value < data) {
            left?.exists(value) ?: false
        } else {
            right?.exists(value) ?: false
        }
    }
}