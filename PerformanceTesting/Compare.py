import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']
        for row in reader:
            size = int(row['Size'].strip('"'))
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load data from both CSVs
custom_data = read_csv('CustomLinkedList_performance.csv')
standard_data = read_csv('LinkedList_performance.csv')

# Find common methods between both
common_methods = sorted(set(custom_data.keys()).intersection(set(standard_data.keys())))
if not common_methods:
    print("No common methods found between CustomLinkedList and LinkedList CSVs.")
    exit()

# Use size values from one dataset
sizes = sorted([size for size, _ in custom_data[common_methods[0]]])
x_max = max(sizes)

# Plotting setup
fig, axes = plt.subplots(nrows=len(common_methods), ncols=1, figsize=(10, 4 * len(common_methods)))
if len(common_methods) == 1:
    axes = [axes]

# Formatters
scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)

# X-axis ticks: start at 2,500, increment by 100,000
x_ticks = list(range(2500, x_max + 1, 100000))

for idx, method in enumerate(common_methods):
    custom_times = [time for _, time in custom_data[method]]
    standard_times = [time for _, time in standard_data.get(method, [(0, 0)] * len(sizes))]

    ax = axes[idx]
    ax.plot(sizes, custom_times, label='CustomLinkedList', linestyle='-', linewidth=1.5)
    ax.plot(sizes, standard_times, label='LinkedList', linestyle='-', linewidth=1.5)

    ax.set_title(method)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.grid(True)
    ax.legend()

    ax.set_xlim(2500, x_max)
    y_max = max(max(custom_times, default=0), max(standard_times, default=0))
    ax.set_ylim(0, y_max * 1.1 if y_max > 0 else 1)

    ax.set_xticks(x_ticks)
    ax.set_xticklabels([f"{tick:,}" for tick in x_ticks], rotation=45, ha='right')
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('CustomLinkedList_vs_LinkedList_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print("Comparison chart saved as 'CustomLinkedList_vs_LinkedList_Performance_Comparisons.png'")
